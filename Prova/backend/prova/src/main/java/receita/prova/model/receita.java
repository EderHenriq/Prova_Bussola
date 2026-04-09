package receita.prova.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "receita_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int tempoPreparo;
    private double custoAproximado;
}
//Fazer esses dois cruds !!!
//addIngrediente(item)
//removerIngrediente(item)