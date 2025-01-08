package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
@Table(name = "Encadernacao")
public class Encadernacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column
    private Integer qnt;
    //MUDAR FLOAT PARA DOUBLE E RESETAR BD
    @Column
    private Float precoTotal; // Essa coluna vai ser o resultado do calculo do insumos e margem de lucro

    //MUDAR FLOAT PARA DOUBLE E RESETAR BD
    @Column
    private Float Lucro; //Por porcentagem.

    @Column
    private int Margem;

    @Column
    private Double valorInsumo;

    private static final Double taxa = 0.05; //5% quando for utilizar fazer multiplicação

    public Encadernacao() {
    }

    //Fazer o toString já formatando os preços com R$

    //Calculo (Taxa 5%) Deixar essa taxa fixa em uma variavel
    // + (% Lucro) Tentar visualizar como String e com %
    // + (% Margem) Tentar visualizar como String e com %

}
