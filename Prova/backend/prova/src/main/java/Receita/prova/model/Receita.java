package Receita.prova.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "receita_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int tempoPreparo;
    private double custoAproximado;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public void addIngrediente(Ingrediente item) {
        item.setReceita(this);
        ingredientes.add(item);
    }

    public void removeIngrediente(Ingrediente item) {
        ingredientes.remove(item);
        item.setReceita(null);
    }
}