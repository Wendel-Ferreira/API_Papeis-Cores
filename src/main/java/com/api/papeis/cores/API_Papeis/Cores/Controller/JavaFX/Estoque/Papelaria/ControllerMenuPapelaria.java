package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Papelaria;

import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerMenuPapelaria {
    @FXML
    public void CenaInicial(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/PaginaInicial.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void CenaAddPapelaria(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Papelaria/AddPapelaria.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void CenaTablePapelaria(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Papelaria/TablePapelaria.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
