package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Insumos")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int qntEstoque;

    @Column(nullable = false)
    private Float precoPacote;

    @Column(nullable = false)
    private Integer qntNoPacote;

    @Column
    private Float valorUnitario;

    @Column
    private Float valorTotalEstoque;


    //Essa função vai ser adicionada no construtor
    public void divPacote(Float precoPacote , Float qntNoPacote){
        Float div = precoPacote / qntNoPacote;
        valorUnitario = div;
    }

    //Essa função vai ser adicionada no construtor
    public void somaEstoque(int qntEstoque,Float precoPacote){
        valorTotalEstoque = qntEstoque * precoPacote;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQntEstoque() {
        return qntEstoque;
    }

    public Float getPrecoPacote() {
        return precoPacote;
    }

    public Integer getQntNoPacote() {
        return qntNoPacote;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public Float getValorTotalEstoque() {
        return valorTotalEstoque;
    }
}
