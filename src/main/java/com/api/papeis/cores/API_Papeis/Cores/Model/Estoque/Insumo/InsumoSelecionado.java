package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo;

import javafx.beans.property.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsumoSelecionado {
    private String nome; // Vem do insumo selecionado
    private Double valorUnitarioInsumo; // Vem do insumo selecionado

    private double valorTotal;

    private Insumo insumo;
    private BooleanProperty boxSelecionado;
    private IntegerProperty qntUsada;

    public InsumoSelecionado(Insumo insumo) {
        this.insumo = insumo;
        this.valorUnitarioInsumo = this.insumo.getValorUnitario();
        this.nome = this.insumo.getNome();
        this.boxSelecionado = new SimpleBooleanProperty(false);
        this.qntUsada = new SimpleIntegerProperty(0);

    }

    public double custoTotal() {
        return qntUsada.get() * valorUnitarioInsumo;
    }

    public void setQntUsada(int quantidadeUsada) {
        this.qntUsada.set(quantidadeUsada);
        this.valorTotal = custoTotal(); // Atualiza o valor total
    }
}
