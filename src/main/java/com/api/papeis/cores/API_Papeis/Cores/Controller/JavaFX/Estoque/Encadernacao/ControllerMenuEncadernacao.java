package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Encadernacao;

import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerMenuEncadernacao {
    @FXML
    public void CenaInicial(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/PaginaInicial.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void CenaAddEncadernacao(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Encadernacao/AddEncadernacao.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void CenaEditarEncadernacao(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Encadernacao/EditarEncadernacao.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void CenaTableEncadernacao(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Encadernacao/TableEncadernacao.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
