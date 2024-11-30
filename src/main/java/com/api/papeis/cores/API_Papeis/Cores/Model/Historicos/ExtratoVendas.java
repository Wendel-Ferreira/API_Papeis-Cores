package com.api.papeis.cores.API_Papeis.Cores.Model.Historicos;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Extrato-Movimentacao")
public class ExtratoVendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public ExtratoVendas() {
    }
}