package com.api.papeis.cores.API_Papeis.Cores.Model.Estoque;

import javafx.beans.property.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsumoSelecionado {
    private Insumo insumo;
    private BooleanProperty boxSelecionado;
    private IntegerProperty qntUsada;

    public InsumoSelecionado(Insumo insumo) {
        this.insumo = insumo;
        this.boxSelecionado = new SimpleBooleanProperty(false);
        this.qntUsada = new SimpleIntegerProperty(0);
    }
    public double custoTotal(){
        return qntUsada.get() * insumo.getValorUnitario();
    }
}
