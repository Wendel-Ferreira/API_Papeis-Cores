package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Papelaria;

import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Papelaria.HttpAddPapelaria;
import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Papelaria;
import com.api.papeis.cores.API_Papeis.Cores.Service.Estoque.PapelariaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Controller
public class ControllerAddPapelaria {

    public HttpAddPapelaria papelaria;
    //Tabela
    @FXML
    private TableView<Papelaria> tablePapelaria;

    private ObservableList<Papelaria> observableListPapelaria;

    //Coluna
    @FXML
    private TableColumn<Papelaria,String> columnNome;
    @FXML
    private TableColumn<Papelaria,Integer> columnQnt;
    @FXML
    private TableColumn<Papelaria,Float> columnPrecoTotal;

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

    //Service
    @Autowired
    private HttpAddPapelaria apiPapelaria;

    @Autowired
    private PapelariaService papelariaService;

    @FXML
    public void cenaMenuPapelaria(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Papelaria/MenuPapelaria.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void visualizarTabela(){
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnQnt.setCellValueFactory(new PropertyValueFactory<>("qnt"));
        columnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));
        carregartabela();
    }

    private void carregartabela(){
        try {
            ObservableList<Papelaria> observableList = FXCollections.observableArrayList(papelaria.findAll());

            tablePapelaria.setItems(observableList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void addPapelaria() throws IOException, InterruptedException {
        String nome = textFieldNome.getText();
        Integer qnt = Integer.parseInt(textFieldQntEstoque.getText());
        Float precoPacote = Float.parseFloat(textFieldPrecoPacote.getText());
        Integer qntPacote = Integer.parseInt(textFieldQntPacote.getText());
        Float lucro = Float.parseFloat(textFieldLucro.getText());
        Integer margem = Integer.parseInt(textFieldMargem.getText());

        Papelaria novoProduto = new Papelaria(nome,qntPacote,precoPacote,qnt,lucro,margem);

        apiPapelaria.savePapelaria(novoProduto);

        textFieldNome.clear();
        textFieldLucro.clear();
        textFieldMargem.clear();
        textFieldQntPacote.clear();
        textFieldQntEstoque.clear();
        textFieldPrecoPacote.clear();
    }
  /*  public void addPapelaria() throws JsonProcessingException {
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