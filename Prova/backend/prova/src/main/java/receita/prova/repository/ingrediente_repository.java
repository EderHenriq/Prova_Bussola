package receita.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import receita.prova.model.ingrediente;

@Repository
public interface ingrediente_repository extends JpaRepository<ingrediente, Long> {
    ingrediente findByName (String nome) ;
}