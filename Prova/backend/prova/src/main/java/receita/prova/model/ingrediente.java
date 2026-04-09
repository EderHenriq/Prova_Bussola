package receita.prova.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingrediente_table")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}


