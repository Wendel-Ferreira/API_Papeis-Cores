package com.api.papeis.cores.API_Papeis.Cores.Service.Cliente;

import com.api.papeis.cores.API_Papeis.Cores.Model.Cliente.Clientes;
import com.api.papeis.cores.API_Papeis.Cores.Repository.Clientes.JpaClientes;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private JpaClientes jpaClientes;

    public Clientes save(Clientes clientes) {
        return jpaClientes.save(clientes);
    }

    public List<Clientes> findAll() {
        return jpaClientes.findAll();
    }

    public void deleteById(Integer id){
        jpaClientes.deleteById(id);
    }
    public void delete(Clientes id) {
        jpaClientes.delete(id);
    }

    public Optional<Clientes> FindById(Integer id) {
        return jpaClientes.findById(id);
    }

    public long count() {
        return jpaClientes.count();
    }

    public Clientes update(Clientes clientes) {
        return jpaClientes.save(clientes);
    }
}
