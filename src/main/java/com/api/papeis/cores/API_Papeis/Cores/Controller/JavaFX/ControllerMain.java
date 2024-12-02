package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX;

import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class ControllerMain implements Initializable {

    @Autowired
    private ConfigurableApplicationContext springContext;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void CenaPapelaria(ActionEvent event){
        try {
        MainApplication.trocaCena("/templates/View/Estoque/AddPapelaria.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void CenaEncadernacao(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/AddEncadernacao.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void CenaInsumo(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/AddInsumo.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void CenaClientes(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Clientes/AddClientes.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void CenaDashboard(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Historicos/Dashboard.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void CenaExtrato(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Historicos/Extrato.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //CRIAR UM LABEL QUE MOSTRE O TOTAL DE ESTOQUE/CLIENTES DE CADA CATEGORIA (NA PAGINA INICIAL)
}
