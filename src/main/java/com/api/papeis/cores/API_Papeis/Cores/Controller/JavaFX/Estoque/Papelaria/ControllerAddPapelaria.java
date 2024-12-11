package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Papelaria;

import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Insumo.HttpInsumo;
import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Papelaria.HttpAddPapelaria;
import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.InsumoSelecionado;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Papelaria;
import com.api.papeis.cores.API_Papeis.Cores.Service.Estoque.PapelariaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class ControllerAddPapelaria implements Initializable {

    //Tabela
    @FXML
    private TableView<Insumo> tableViewInsumo;

    //Coluna
    @FXML
    private TableColumn<Insumo, String> columnNome;
    @FXML
    private TableColumn<Insumo, Float> columnValorUni;
    @FXML
    private TableColumn<InsumoSelecionado,Boolean> checkBox;
    @FXML
    private TableColumn<InsumoSelecionado, Integer> columnQntEstoque;

    //Caixa de Texto
    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldQntEstoque;
    @FXML
    private TextField textFieldPrecoPacote;
    @FXML
    private TextField textFieldQntPacote;
    @FXML
    private TextField textFieldLucro;
    @FXML
    private TextField textFieldMargem;

    @FXML
    private Button buttonAdd;

    @Autowired
    private HttpInsumo httpInsumo;
    @Autowired
    private HttpAddPapelaria httpAddPapelaria;

    @FXML
    public void cenaMenuPapelaria(ActionEvent event) {
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Papelaria/MenuPapelaria.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void visualizarTabela() {
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnValorUni.setCellValueFactory(new PropertyValueFactory<>("valorTotalEstoque"));
       //checkBox.setCellValueFactory(check -> {});
        columnValorUni.setCellValueFactory(new PropertyValueFactory<>("valorTotalEstoque"));
        carregartabela();
    }

    private void carregartabela() {
        try {
            ObservableList<Insumo> observableList = FXCollections.observableArrayList(httpInsumo.httpFindAllInsumo());
            tableViewInsumo.setItems(observableList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void addPapelaria() throws IOException, InterruptedException {
        String nome = textFieldNome.getText();
        Integer qnt = Integer.parseInt(textFieldQntEstoque.getText());
        Float precoPacote = Float.parseFloat(textFieldPrecoPacote.getText());
        Integer qntPacote = Integer.parseInt(textFieldQntPacote.getText());
        Float lucro = Float.parseFloat(textFieldLucro.getText());
        Integer margem = Integer.parseInt(textFieldMargem.getText());

        Papelaria novoProduto = new Papelaria(nome, qntPacote, precoPacote, qnt, lucro, margem);

        httpAddPapelaria.savePapelaria(novoProduto);
        visualizarTabela();
        textFieldNome.clear();
        textFieldLucro.clear();
        textFieldMargem.clear();
        textFieldQntPacote.clear();
        textFieldQntEstoque.clear();
        textFieldPrecoPacote.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        visualizarTabela();
    }
  /*
  public void addPapelaria() throws JsonProcessingException {
        String nome = textFieldNome.getText();
        Integer qnt = Integer.parseInt(textFieldQntEstoque.getText());
        Float precoPacote = Float.parseFloat(textFieldPrecoPacote.getText());
        Integer qntPacote = Integer.parseInt(textFieldQntPacote.getText());
        Float lucro = Float.parseFloat(textFieldLucro.getText());
        Integer margem = Integer.parseInt(textFieldMargem.getText());

        Papelaria novoProduto = new Papelaria(nome,qntPacote,precoPacote,qnt,lucro,margem);

        String url = "http://localhost:8080/api/papelaria/save";

        try{
            restTemplate.postForObject(url,novoProduto,Papelaria.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        textFieldNome.clear();
        textFieldLucro.clear();
        textFieldMargem.clear();
        textFieldQntPacote.clear();
        textFieldQntEstoque.clear();
        textFieldPrecoPacote.clear();
    }

   */
}