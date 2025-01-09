package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Getter
@Table(name = "Papelaria")
public class Papelaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer qntEstoque;

    @Column(precision = 10 , scale = 2)
    private BigDecimal precoTotal; // Essa coluna vai ser o resultado do calculo do insumos,Taxa(5%) % lucro , % margem

    @Column(nullable = false)
    private Double precoPacote;

    @Column(nullable = false)
    private Integer qntNoPacote;

    @Column
    private Double valorUnitario;

    @Column
    private Double lucro; //Por porcentagem.

    @Column
    private Double margem;

    @Column
    private Double valorInsumos;

    private static final Float taxa = 0.05f ; // Criar o calculo e colocar nessa variavel

    public Papelaria(){

    }

    public Papelaria(String nome, Integer qntNoPacote, Double precoPacote, Integer qntEstoque, Double lucro, Double margem, Double valorInsumos) {
        this.nome = nome;
        this.qntNoPacote = qntNoPacote;
        this.precoPacote = precoPacote;
        this.qntEstoque = qntEstoque;
        this.lucro = lucro / 100d;
        this.margem = margem / 100d;
        this.valorInsumos = valorInsumos;
        this.valorUnitario = precoPacote / qntNoPacote;
        this.precoTotal = soma();
    }

    public BigDecimal soma() {
        Double tomate = margem + lucro + taxa;
        Double batata = valorUnitario + valorInsumos;
        return BigDecimal.valueOf(batata)
                .divide(BigDecimal.valueOf(1 - (tomate)), 2);
    }

}
