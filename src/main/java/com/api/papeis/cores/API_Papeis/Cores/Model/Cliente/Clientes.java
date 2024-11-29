package com.api.papeis.cores.API_Papeis.Cores.Model.Cliente;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes-Papeis&Cores")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}