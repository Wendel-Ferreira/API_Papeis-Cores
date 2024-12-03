package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Clientes;

import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerMenuClientes {
    @FXML
    public void CenaAddClientes(ActionEvent event) {
        try {
            MainApplication.trocaCena("/templates/View/Clientes/AddClientes.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void CenaEditarClientes(ActionEvent event) {
        try {
            MainApplication.trocaCena("/templates/View/Clientes/EditarClientes.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void CenaTableClientes(ActionEvent event) {
        try {
            MainApplication.trocaCena("/templates/View/Clientes/TableClientes.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void CenaInicial(ActionEvent event) {
        try {
            MainApplication.trocaCena("/templates/View/PaginaInicial.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
