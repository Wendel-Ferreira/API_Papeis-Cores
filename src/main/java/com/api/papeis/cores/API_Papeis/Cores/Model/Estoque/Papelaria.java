package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private Integer qnt;

    @Column
    private Float precoTotal; // Essa coluna vai ser o resultado do calculo do insumos,Taxa(5%) % lucro , % margem

    @Column(nullable = false)
    private Float precoPacote;

    @Column(nullable = false)
    private Integer qntNoPacote;

    @Column
    private Float valorUnitario;

    @Column
    private Float lucro; //Por porcentagem.

    @Column
    private Integer margem;

    private static final Float taxa = 0.05f ; // Criar o calculo e colocar nessa variavel



    //perguntar se que uma coluna de descrição

    public Papelaria(){

    }

    public Papelaria(String nome, Integer qntNoPacote, Float precoPacote, Integer qnt, Float lucro, Integer margem) {
        this.nome = nome;
        this.qntNoPacote = qntNoPacote;
        this.precoPacote = precoPacote;
        this.qnt = qnt;
        this.lucro = lucro;
        this.margem = margem;
        soma();
    }

    public void soma(){
        Float valor = precoPacote / qntNoPacote;
        precoTotal = valor * qnt;
    }

    //Essa função preçoPAcote / qntNoPacote , = valorUnitario)
    public void divPacote(Float precoPacote , Float qntNoPacote){
        Float div = precoPacote / qntNoPacote;

    }

    // + (% Lucro) Tentar visualizar como String e com %, 1º
    //Calculo (Taxa 5%) Deixar essa taxa fixa em uma variavel, 2º
    // + (% Margem) Tentar visualizar como String e com %, 3º
}
