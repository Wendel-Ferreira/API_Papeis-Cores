package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque;

import jakarta.persistence.*;

import java.util.List;

//Será entidade
@Entity
@Table(name = "Encadernacao")
public class Encadernacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    private Float todosInsumos;

    @Column
    private int qnt;

    @Column
    private Float precoTotal; // Essa coluna vai ser o resultado do calculo do insumos e margem de lucro

    @Column
    private Float Lucro; //Por porcentagem.

    @Column
    private int Margem;


    //Calculo (Taxa 5%) Deixar essa taxa fixa em uma variavel
    // + (% Lucro) Tentar visualizar como String e com %
    // + (% Margem) Tentar visualizar como String e com %

    public Integer getId() {
        return id;
    }

    public Float getTodosInsumos() {
        return todosInsumos;
    }

    public String getNome() {
        return nome;
    }


    public int getQnt() {
        return qnt;
    }

    public Float getPrecoTotal() {
        return precoTotal;
    }

    public Float getLucro() {
        return Lucro;
    }

    public int getMargem() {
        return Margem;
    }
}
