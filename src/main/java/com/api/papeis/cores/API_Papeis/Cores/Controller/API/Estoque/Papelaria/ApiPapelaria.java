package com.api.papeis.cores.API_Papeis.Cores.Controller.API.Estoque.Papelaria;

import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Papelaria;
import com.api.papeis.cores.API_Papeis.Cores.Service.Estoque.PapelariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/papelaria")
public class ApiPapelaria {

    @Autowired
    private PapelariaService papelariaService;

    @GetMapping("/findAll")
    public List<Papelaria> findAll(){return papelariaService.findAll();}

    @PostMapping("/save")
    public Papelaria save(@RequestBody Papelaria papelaria){
    return papelariaService.save(papelaria);}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){papelariaService.deleteById(id);}

    @GetMapping("/count")
    public long count(){return papelariaService.count();}

    @GetMapping("/{id}")
    public Optional<Papelaria> findById(@PathVariable Integer id){return papelariaService.findById(id);}

    @PutMapping("/update")
    public Papelaria update(@RequestBody Papelaria papelaria){
        return papelariaService.update(papelaria);
    }
}
