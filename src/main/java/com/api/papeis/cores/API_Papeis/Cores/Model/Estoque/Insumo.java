package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque;

import jakarta.persistence.*;
import lombok.Getter;


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
    private Float precoPacote;

    @Column(nullable = false)
    private Integer qntNoPacote;

    @Column
    private Float valorUnitario;

    @Column
    private Float valorTotalEstoque;

    public Insumo() {
    }

    public Insumo(String nome, Integer qntEstoque, Float precoPacote, Integer qntNoPacote) {
        this.nome = nome;
        this.qntEstoque = qntEstoque;
        this.precoPacote = precoPacote;
        this.qntNoPacote = qntNoPacote;
        this.valorUnitario = divPacote();
        this.valorTotalEstoque = somaEstoque();
    }

    public Float divPacote(){
        return precoPacote / qntNoPacote;
    }

    public Float somaEstoque(){
        return qntEstoque * precoPacote;
    }

}
