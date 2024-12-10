package com.api.papeis.cores.API_Papeis.Cores.Controller.API.Estoque.Encadernacao;

import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Encadernacao;
import com.api.papeis.cores.API_Papeis.Cores.Service.Estoque.EncadernacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/add/encadernacao")
public class ApiEncadernacao {

    @Autowired
    private EncadernacaoService produtoService;

    @GetMapping
    public List<Encadernacao> findiAll() {
        return produtoService.findAll();
    }
    @PutMapping
    public Encadernacao update(@RequestBody Encadernacao encadernacao) {
        return produtoService.update(encadernacao);
    }
    @PostMapping
    public Encadernacao save(@RequestBody Encadernacao produtos) { return produtoService.save(produtos);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {produtoService.deleteById(id);}

    @GetMapping("/{id}")
    public Optional<Encadernacao> findById(@PathVariable Integer id) {return produtoService.findbyId(id);}

    @GetMapping("/count")
    public long count() {return produtoService.count();}

}