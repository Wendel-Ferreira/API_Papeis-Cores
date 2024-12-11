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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class ControllerAddInsumo implements Initializable {

    @Autowired
    private HttpInsumo httpInsumo;

    @FXML
    private TableView<Insumo> tableViewInsumo;
    @FXML
    private TableColumn<Insumo,String> columnNome;
    @FXML
    private TableColumn<Insumo,Integer>columnQntEstoque;
    @FXML
    private TableColumn<Insumo,Float> columnValorUni;

    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldQntNoEstoque;
    @FXML
    private TextField textFieldPrecoPacote;
    @FXML
    private TextField textFieldQntNoPacote;

    //Botão voltar
    @FXML
    public void CenaMenuInsumo(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Insumo/MenuInsumo.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void carregarColunas() {
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnQntEstoque.setCellValueFactory(new PropertyValueFactory<>("qntEstoque"));
        columnValorUni.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        carregarTabela();
    }

    public void carregarTabela() {
        try {
            ObservableList<Insumo> observableList = FXCollections.observableArrayList(httpInsumo.httpFindAllInsumo()); //precisa criar o http
            tableViewInsumo.setItems(observableList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void addInsumo(){
        try {
            String nome = textFieldNome.getText();
            Integer qntEstoque = Integer.parseInt(textFieldQntNoEstoque.getText());
            Float precoPacote = Float.parseFloat(textFieldPrecoPacote.getText());
            Integer qntPacote = Integer.parseInt(textFieldQntNoPacote.getText());

            Insumo novoInsumo = new Insumo(nome,qntEstoque,precoPacote,qntPacote);

            httpInsumo.httpSaveInsumo(novoInsumo);
            carregarColunas();
            textFieldNome.clear();
            textFieldQntNoEstoque.clear();
            textFieldPrecoPacote.clear();
            textFieldQntNoPacote.clear();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    carregarColunas();
    }
}
