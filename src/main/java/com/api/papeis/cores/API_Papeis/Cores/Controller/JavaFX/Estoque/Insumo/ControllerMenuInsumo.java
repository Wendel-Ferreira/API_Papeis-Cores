package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Insumo;

import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerMenuInsumo {
    @FXML
    public void cenaAddInsumo(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Insumo/AddInsumo.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void cenaEditarInsumo(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Insumo/EditarInsumo.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void cenaTableInsumo(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Insumo/TableInsumo.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void CenaInicial(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/PaginaInicial.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
