package com.api.papeis.cores.API_Papeis.Cores.Repository.Clientes;

import com.api.papeis.cores.API_Papeis.Cores.Model.Cliente.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClientes extends JpaRepository<Clientes,Integer> {
}
