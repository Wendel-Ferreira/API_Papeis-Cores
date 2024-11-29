package com.api.papeis.cores.API_Papeis.Cores.Repository.Historicos;

import com.api.papeis.cores.API_Papeis.Cores.Model.Historicos.ExtratoVendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaExtratoVendas extends JpaRepository<ExtratoVendas,Integer> {
}
