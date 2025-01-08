package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Papelaria;

import com.api.papeis.cores.API_Papeis.Cores.Controller.API.Estoque.Papelaria.ApiPapelaria;
import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Papelaria.HttpAddPapelaria;
import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Papelaria;
import jakarta.persistence.Column;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class ControllerTablePapelaria implements Initializable {

    @Autowired
    private HttpAddPapelaria httpAddPapelaria;

    @FXML
    private TableView<Papelaria> tableView;
    @FXML
    private TableColumn<Papelaria, String> columnNome;
    @FXML
    private TableColumn<Papelaria, Integer> columnQntEstoque;
    @FXML
    private TableColumn<Papelaria, Float> columnPrecoPacote;
    @FXML
    private TableColumn<Papelaria, Integer> columnQntNoPacote;
    @FXML
    private TableColumn<Papelaria, Double> columnValorUnitario;
    @FXML
    private TableColumn<Papelaria, Double> columnTotalEstoque;
    @FXML
    private TableColumn<Papelaria, Double> columnValorInsumos;

    //Botão voltar
    @FXML
    public void cenaMenuPapelaria(ActionEvent event) {
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Papelaria/MenuPapelaria.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void visualizarTabela() throws Exception {
            columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            columnQntEstoque.setCellValueFactory(new PropertyValueFactory<>("qntEstoque"));
            columnPrecoPacote.setCellValueFactory(new PropertyValueFactory<>("precoPacote"));
            columnQntNoPacote.setCellValueFactory(new PropertyValueFactory<>("qntNoPacote"));
            columnValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
            columnTotalEstoque.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));
            columnValorInsumos.setCellValueFactory(new PropertyValueFactory<>("valorInsumos"));
            carregarTabela();
    }

    public void carregarTabela() {
        try {
            ObservableList<Papelaria> observableList = FXCollections.observableArrayList(httpAddPapelaria.findAll());
            tableView.setItems(observableList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            visualizarTabela();
            carregarTabela();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
