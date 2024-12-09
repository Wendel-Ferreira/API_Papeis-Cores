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

    private Float taxa; // Criar o calculo e colocar nessa variavel

    public Papelaria() {
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

    @Override
    public String toString() {
        return "Papelaria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", qnt=" + qnt +
                ", precoTotal=" + precoTotal +
                ", precoPacote=" + precoPacote +
                ", qntNoPacote=" + qntNoPacote +
                ", valorUnitario=" + valorUnitario +
                ", Lucro=" + lucro +
                ", Margem=" + margem +
                ", taxa=" + taxa +
                '}';
    }
    //Fazer o toString já formatando os preços com R$

    //Calculo (Taxa 5%) Deixar essa taxa fixa em uma variavel, 1º
    // + (% Lucro) Tentar visualizar como String e com %, 2º
    // + (% Margem) Tentar visualizar como String e com %, 3º
}
