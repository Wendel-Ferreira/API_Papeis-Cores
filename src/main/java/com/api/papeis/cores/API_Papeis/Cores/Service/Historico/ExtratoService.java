package com.api.papeis.cores.API_Papeis.Cores.Service.Historico;

import com.api.papeis.cores.API_Papeis.Cores.Repository.Historicos.JpaExtratoVendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtratoService {
   @Autowired
   private JpaExtratoVendas jpaExtrato;

}
