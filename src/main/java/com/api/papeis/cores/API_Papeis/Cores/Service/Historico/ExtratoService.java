package com.api.papeis.cores.API_Papeis.Cores.Service.Historico;

import com.api.papeis.cores.API_Papeis.Cores.Model.Historicos.ExtratoVendas;
import com.api.papeis.cores.API_Papeis.Cores.Repository.Historicos.JpaExtratoVendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtratoService {

    private JpaExtratoVendas jpaExtrato;

    public ExtratoVendas save(ExtratoVendas extratoVendas) {
        return jpaExtrato.save(extratoVendas);
    }

    public void delete(ExtratoVendas extratoVendas) {
        jpaExtrato.delete(extratoVendas);
    }
   public void deleteById(Integer id){
      jpaExtrato.deleteById(id);
   }
    public List<ExtratoVendas> findAll() {
        return jpaExtrato.findAll();
    }

    public Optional<ExtratoVendas> findById(Integer id) {
        return jpaExtrato.findById(id);
    }

    public long count() {
        return jpaExtrato.count();
    }

    public ExtratoVendas update(ExtratoVendas extratoVendas) {
        return jpaExtrato.save(extratoVendas);
    }
}
