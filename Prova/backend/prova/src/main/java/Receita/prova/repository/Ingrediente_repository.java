package Receita.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Receita.prova.model.Ingrediente;

@Repository
public interface Ingrediente_repository extends JpaRepository<Ingrediente, Long> {
}