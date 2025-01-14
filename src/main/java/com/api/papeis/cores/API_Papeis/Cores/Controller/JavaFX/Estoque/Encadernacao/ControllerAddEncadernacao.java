package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Encadernacao;

import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerAddEncadernacao {

    @FXML
    public void CenaInicial(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/MenuEncadernacao.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
