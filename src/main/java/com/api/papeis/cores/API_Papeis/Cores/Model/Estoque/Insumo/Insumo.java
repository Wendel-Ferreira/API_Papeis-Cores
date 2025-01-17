package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;


@Entity
@Getter
@Table(name = "Insumos")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column
    private Integer qntEstoque;

    @Column(nullable = false)
    private Double precoPacote;

    @Column(nullable = false)
    private Integer qntNoPacote;

    @Column
    private Double valorUnitario;

    @Column
    private Double valorTotalEstoque;

    public Insumo() {
    }

    public Insumo(String nome, Integer qntEstoque, Double precoPacote, Integer qntNoPacote) {
        this.nome = nome;
        this.qntEstoque = qntEstoque;
        this.precoPacote = precoPacote;
        this.qntNoPacote = qntNoPacote;
        this.valorUnitario = divPacote();
        this.valorTotalEstoque = somaEstoque();
    }

    public Double divPacote(){
        BigDecimal bigDecimal = new BigDecimal(precoPacote / qntNoPacote).setScale(2);
        return bigDecimal.doubleValue();
    }

    public Double somaEstoque(){
        BigDecimal round = new BigDecimal(qntEstoque * precoPacote).setScale(2);
        return round.doubleValue();
    }
}
