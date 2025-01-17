package com.api.papeis.cores.API_Papeis.Cores.Service.Estoque;

import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Papelaria.Papelaria;
import com.api.papeis.cores.API_Papeis.Cores.Repository.Estoque.JpaPapelaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PapelariaService {
    @Autowired
    private JpaPapelaria jpaPapelaria;

    public Papelaria save(Papelaria papelaria) {
        return jpaPapelaria.save(papelaria);
    }

    public void delete(Papelaria papelaria) {
        jpaPapelaria.delete(papelaria);
    }
    public void deleteById(Integer id){
        jpaPapelaria.deleteById(id);
    }
    public List<Papelaria> findAll() {
        return jpaPapelaria.findAll();
    }

    public long count() {
        return jpaPapelaria.count();
    }

    public Optional<Papelaria> findById(Integer id) {
        return jpaPapelaria.findById(id);
    }

    public Papelaria update(Papelaria papelaria) {
        return jpaPapelaria.save(papelaria);
    }
}