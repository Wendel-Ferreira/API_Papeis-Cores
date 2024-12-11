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

    @Column(nullable = false)
    private Integer qntEstoque;

    @Column(nullable = false)
    private Float precoPacote;

    @Column(nullable = false) //Tirar nullable porém precisa apagar no banco de dados
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
    }

    //Essa função vai ser adicionada no construtor
    public void divPacote(Float precoPacote , Float qntNoPacote){
        Float div = precoPacote / qntNoPacote;
        valorUnitario = div;
    }

    //Essa função vai ser adicionada no construtor
    public void somaEstoque(int qntEstoque,Float precoPacote){
        valorTotalEstoque = qntEstoque * precoPacote;
    }

    //Fazer o toString já formatando os preços com R$
}
