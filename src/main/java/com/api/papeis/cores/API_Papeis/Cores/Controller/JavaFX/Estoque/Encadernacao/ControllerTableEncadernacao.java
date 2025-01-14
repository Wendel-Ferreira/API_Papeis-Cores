package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Encadernacao;

import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Encadernacao.HttpEncadernacao;
import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Encadernacao;
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
public class ControllerTableEncadernacao implements Initializable {

    @Autowired
    private HttpEncadernacao httpEncadernacao;

    @FXML
    private TableView<Encadernacao> tableViewEncadernacao;
    @FXML
    private TableColumn<Encadernacao, String> columnNome;
    @FXML
    private TableColumn<Encadernacao, Integer> columnQntEstoque;
    @FXML
    private TableColumn<Encadernacao, Double> columnLucro;
    @FXML
    private TableColumn<Encadernacao, Double> columnMargem;
    @FXML
    private TableColumn<Encadernacao, Double> columnValorTotal;
    @FXML
    private TableColumn<Encadernacao, Double> columnValorInsumo;
    
    public void visualizarTabela(){
    columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    columnQntEstoque.setCellValueFactory(new PropertyValueFactory<>("qntEstoque"));
    columnLucro.setCellValueFactory(new PropertyValueFactory<>("lucro"));
    columnMargem.setCellValueFactory(new PropertyValueFactory<>("margem"));
    columnValorTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));
    columnValorInsumo.setCellValueFactory(new PropertyValueFactory<>("valorInsumo"));
    carregarTabela();
    }

    public void carregarTabela(){
        try {
            ObservableList<Encadernacao> observableList = FXCollections.observableArrayList(httpEncadernacao.findAll());
            tableViewEncadernacao.setItems(observableList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    public void cenaMenuEncadernacao(ActionEvent event) {
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Encadernacao/MenuEncadernacao.fxml");
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
