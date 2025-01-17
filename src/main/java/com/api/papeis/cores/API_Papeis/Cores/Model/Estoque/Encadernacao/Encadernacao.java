package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Encadernacao;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;


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
    private Integer qntEstoque;

    @Column(precision = 10 , scale = 2)
    private BigDecimal precoTotal; // Essa coluna vai ser o resultado do calculo do insumos e margem de lucro

    @Column
    private Double lucro; //Por porcentagem.

    @Column
    private Double margem;

    @Column
    private Double valorInsumo;

    private static final Double taxa = 0.05; //5% quando for utilizar fazer multiplicação

    public Encadernacao() {
    }

    public Encadernacao(String nome, Integer qntEstoque, Double lucro, Double margem, Double valorInsumo) {
        this.nome = nome;
        this.qntEstoque = qntEstoque;
        this.lucro = lucro ;
        this.margem = margem;
        this.valorInsumo = valorInsumo;
        this.precoTotal = soma();
    }
    public BigDecimal soma(){
        Double porcentagem = (getLucro()/100) + (getMargem()/100) + taxa;

        return BigDecimal.valueOf(getValorInsumo())
                .divide(BigDecimal.valueOf((1 - porcentagem)));
    }

}
