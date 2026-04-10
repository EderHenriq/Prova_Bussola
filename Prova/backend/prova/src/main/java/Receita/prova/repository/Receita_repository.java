package Receita.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Receita.prova.model.Receita;

@Repository
public interface Receita_repository extends JpaRepository<Receita, Long> {

}