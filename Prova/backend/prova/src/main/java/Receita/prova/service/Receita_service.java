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

    public Receita addIngrediente(Long receitaId, Ingrediente item) {
        Receita r = buscarPorId(receitaId);
        r.addIngrediente(item);
        return receitaRepository.save(r);
    }

    public Receita removeIngrediente(Long receitaId, Long ingredienteId) {
        Receita r = buscarPorId(receitaId);
        r.getIngredientes().removeIf(i -> i.getId().equals(ingredienteId));
        return receitaRepository.save(r);
    }
}