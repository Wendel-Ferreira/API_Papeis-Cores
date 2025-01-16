package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Insumo;

import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Insumo.HttpInsumo;
import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo;
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
public class ControllerTableInsumo implements Initializable {

    @Autowired
    private HttpInsumo httpInsumo;

    @FXML
    private TableView<Insumo> insumoTableView;
    @FXML
    private TableColumn<Insumo , String> tableColumnNome;
    @FXML
    private TableColumn<Insumo ,Integer> tableColumnQntEstoque;
    @FXML
    private TableColumn<Insumo , Float> tableColumnPrecoPacote;
    @FXML
    private TableColumn<Insumo, Integer> tableColumnQntNoPacote;
    @FXML
    private TableColumn<Insumo, Float> tableColumnValorUni;
    @FXML
    private TableColumn<Insumo, Float> tableColumnValorTotalEstoque;

    public void carregarTabela(){
        try {
            tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            tableColumnQntEstoque.setCellValueFactory(new PropertyValueFactory<>("qntEstoque"));
            tableColumnPrecoPacote.setCellValueFactory(new PropertyValueFactory<>("precoPacote"));
            tableColumnQntNoPacote.setCellValueFactory(new PropertyValueFactory<>("qntNoPacote"));
            tableColumnValorUni.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
            tableColumnValorTotalEstoque.setCellValueFactory(new PropertyValueFactory<>("valorTotalEstoque"));
            visualizarTabela();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void visualizarTabela(){
        try {
            ObservableList<Insumo> observableList = FXCollections.observableArrayList(httpInsumo.httpFindAllInsumo());
            insumoTableView.setItems(observableList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Botão voltar
    @FXML
    public void CenaMenuInsumo(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Insumo/MenuInsumo.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            carregarTabela();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
