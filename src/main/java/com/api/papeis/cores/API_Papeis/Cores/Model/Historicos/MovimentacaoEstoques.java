package com.api.papeis.cores.API_Papeis.Cores.Model.Historicos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class MovimentacaoEstoques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public MovimentacaoEstoques() {
    }
}
