package receita.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import receita.prova.model.receita;

@Repository
public interface Receita_repository extends JpaRepository<receita, Long> {
    receita findByName (String nome) ;
}