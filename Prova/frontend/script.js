const API_Receitas = 'http://localhost:8080/api/receitas';

async function listarReceitas() {
    const resposta = await fetch(API_Receitas);
    const receitas = await resposta.json();

    const div = document.getElementById('lista');
    div.innerHTML = '';

    receitas.forEach(r => {
        const ingredientes = r.ingredientes.map(i => `${i.id} - ${i.nome}`).join(', ') || 'Nenhum';
        div.innerHTML += `
            <p>
                <strong>ID:</strong> ${r.id} |
                <strong>Nome:</strong> ${r.nome} |
                <strong>Tempo:</strong> ${r.tempoPreparo} min |
                <strong>Custo:</strong> R$ ${r.custoAproximado} |
                <strong>Ingredientes:</strong> ${ingredientes}
            </p>
            <hr>
        `;
    });
}

async function criarReceita() {
    const body = {
        nome: document.getElementById('nome').value,
        tempoPreparo: parseInt(document.getElementById('tempoPreparo').value),
        custoAproximado: parseFloat(document.getElementById('custo').value)
    };

    await fetch(API_Receitas, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(body)
    });

    listarReceitas();
}

async function adicionarIngrediente() {
    const receitaId = document.getElementById('receitaId').value;
    const body = { nome: document.getElementById('nomeIngrediente').value };

    await fetch(`${API_Receitas}/${receitaId}/ingredientes`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(body)
    });

    listarReceitas();
}

async function removerIngrediente() {
    const receitaId = document.getElementById('receitaIdRemover').value;
    const ingredienteId = document.getElementById('ingredienteIdRemover').value;

    await fetch(`${API_Receitas}/${receitaId}/ingredientes/${ingredienteId}`, {
        method: 'DELETE'
    });

    listarReceitas();
}

async function deletarReceita() {
    const id = document.getElementById('idDeletar').value;

    await fetch(`${API_Receitas}/${id}`, { method: 'DELETE' });

    listarReceitas();
}


listarReceitas();
