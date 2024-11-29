
package com.api.papeis.cores.API_Papeis.Cores.Service.Estoque;

import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Encadernacao;
import com.api.papeis.cores.API_Papeis.Cores.Repository.Estoque.JpaEncadernacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EncadernacaoService {

    @Autowired
    private JpaEncadernacao jpaProduto;

    public List<Encadernacao> findAll(){
        return jpaProduto.findAll();
    }

    public void deleteById(Integer id){
        jpaProduto.deleteById(id);
    }

    public Encadernacao save(Encadernacao produtos){
        return jpaProduto.save(produtos);
    }

    public Optional<Encadernacao> findbyId(Integer id){
        return jpaProduto.findById(id);
    }

    public Encadernacao update(Encadernacao produtos){
        return jpaProduto.save(produtos);
    }


    //Criar uma função que faz o cliente procurar pelo nome e pegar o id desse produto e jogar no FindByID
}