package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Papelaria")
public class Papelaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int qnt;

    @Column
    private Float precoTotal; // Essa coluna vai ser o resultado do calculo do insumos,Taxa(5%) % lucro , % margem

    @Column(nullable = false)
    private Float precoPacote;

    @Column(nullable = false)
    private Integer qntNoPacote;

    @Column
    private Float valorUnitario;

    @Column
    private Float Lucro; //Por porcentagem.

    @Column
    private int Margem;

    private Float taxa; // Criar o calculo e colocar nessa variavel

    //Essa função preçoPAcote / qntNoPacote , = valorUnitario)
    public void divPacote(Float precoPacote , Float qntNoPacote){
        Float div = precoPacote / qntNoPacote;

    }




    //Calculo (Taxa 5%) Deixar essa taxa fixa em uma variavel, 1º
    // + (% Lucro) Tentar visualizar como String e com %, 2º
    // + (% Margem) Tentar visualizar como String e com %, 3º


    public Integer getId() {
        return id;
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

    public Float getPrecoPacote() {
        return precoPacote;
    }

    public Integer getQntNoPacote() {
        return qntNoPacote;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public Float getLucro() {
        return Lucro;
    }

    public int getMargem() {
        return Margem;
    }

    public Float getTaxa() {
        return taxa;
    }
}
