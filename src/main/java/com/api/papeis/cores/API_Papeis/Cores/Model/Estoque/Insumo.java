package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

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
    private int qntEstoque;

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
