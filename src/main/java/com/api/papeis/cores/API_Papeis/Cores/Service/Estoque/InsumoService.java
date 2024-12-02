package com.api.papeis.cores.API_Papeis.Cores.Service.Estoque;

import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo;
import com.api.papeis.cores.API_Papeis.Cores.Repository.Estoque.JpaInsumo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {
    private JpaInsumo jpaInsumo;

    public Insumo save(Insumo insumo) {
        return jpaInsumo.save(insumo);
    }

    public void delete(Insumo id) {
        jpaInsumo.delete(id);
    }

    public void deleteById(Integer id){
        jpaInsumo.deleteById(id);
    }

    public List<Insumo> findAll() {
        return jpaInsumo.findAll();
    }

    public Insumo update(Insumo insumo) {
        return jpaInsumo.save(insumo);
    }

    public Optional<Insumo> FindById(Integer id) {
        return jpaInsumo.findById(id);
    }

    public long count() {
        return jpaInsumo.count();
    }
}