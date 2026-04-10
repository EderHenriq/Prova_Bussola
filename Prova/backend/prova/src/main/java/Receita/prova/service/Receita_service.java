package Receita.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Receita.prova.model.Ingrediente;
import Receita.prova.model.Receita;
import Receita.prova.repository.Receita_repository;
import Receita.prova.repository.Ingrediente_repository;
import java.util.List;

@Service
public class Receita_service {

    @Autowired
    private Receita_repository receitaRepository;

    @Autowired
    private Ingrediente_repository ingredienteRepository;

    public List<Receita> listarTodas() {
        return receitaRepository.findAll();
    }

    public Receita buscarPorId(Long id) {
        return receitaRepository.findById(id).orElseThrow();
    }

    public Receita salvar(Receita r) {
        return receitaRepository.save(r);
    }

    public void deletar(Long id) {
        receitaRepository.deleteById(id);
    }

    public Receita addIngrediente(Long id, Ingrediente item) {
        return null;
    }

    public Receita removeIngrediente(Long receitaId, Long ingredienteId) {
        return null;
    }
}