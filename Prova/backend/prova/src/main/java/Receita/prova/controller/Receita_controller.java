package Receita.prova.controller;

import Receita.prova.service.Receita_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Receita.prova.model.Ingrediente;
import Receita.prova.model.Receita;
import Receita.prova.service.Receita_service;
import java.util.List;

@RestController
@RequestMapping("/api/receitas")
@CrossOrigin(origins = "*")
public class Receita_controller {

    @Autowired
    private Receita_service service;

    @GetMapping
    public List<Receita> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Receita buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Receita criar(@RequestBody Receita r) {
        return service.salvar(r);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PostMapping("/{id}/ingredientes")
    public Receita addIngrediente(@PathVariable Long id, @RequestBody Ingrediente item) {
        return service.addIngrediente(id, item);
    }

    @DeleteMapping("/{receitaId}/ingredientes/{ingredienteId}")
    public Receita removeIngrediente(@PathVariable Long receitaId, @PathVariable Long ingredienteId) {
        return service.removeIngrediente(receitaId, ingredienteId);
    }
}