package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Papelaria;

import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerTablePapelaria {

    //Botão voltar
    @FXML
    public void cenaMenuPapelaria(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Papelaria/MenuPapelaria.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
