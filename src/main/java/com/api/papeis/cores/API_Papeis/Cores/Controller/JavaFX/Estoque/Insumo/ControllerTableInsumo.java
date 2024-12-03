package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Insumo;

import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerTableInsumo {
    //Botão voltar
    @FXML
    public void CenaInicial(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/PaginaInicial.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
