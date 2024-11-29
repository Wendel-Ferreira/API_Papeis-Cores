package com.api.papeis.cores.API_Papeis.Cores.Repository.Estoque;

import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Encadernacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEncadernacao extends JpaRepository<Encadernacao,Integer> {
}
