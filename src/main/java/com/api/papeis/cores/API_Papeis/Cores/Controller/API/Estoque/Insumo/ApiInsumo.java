package com.api.papeis.cores.API_Papeis.Cores.Controller.API.Estoque.Insumo;

import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo;
import com.api.papeis.cores.API_Papeis.Cores.Service.Estoque.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/insumo")
public class ApiInsumo {
    @Autowired
    private InsumoService insumoService;

    @GetMapping
    public List<Insumo> findAll(){return insumoService.findAll();}

    @PostMapping
    public Insumo save(@RequestBody Insumo insumo){return insumoService.save(insumo);}

    @DeleteMapping
    public void deleteById(@PathVariable Integer id){insumoService.deleteById(id); ;}

    @GetMapping("/count")
    public long count(){return insumoService.count();}

    @GetMapping("/{id}")
    public Optional<Insumo> findById(@PathVariable Integer id){return insumoService.FindById(id);}
}
