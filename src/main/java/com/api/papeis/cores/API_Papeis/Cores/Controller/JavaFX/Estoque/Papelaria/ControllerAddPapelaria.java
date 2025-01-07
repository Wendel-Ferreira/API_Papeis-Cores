package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Papelaria;

import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Insumo.HttpInsumo;
import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Papelaria.HttpAddPapelaria;
import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.InsumoSelecionado;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Papelaria;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class ControllerAddPapelaria implements Initializable {

    //Tabela
    @FXML
    private TableView<InsumoSelecionado> tableViewInsumo;

    //Testar o checkBox
    private InsumoSelecionado insumoSelecionado;

    //Coluna
    @FXML
    private TableColumn<InsumoSelecionado, String> columnNome;
    @FXML
    private TableColumn<InsumoSelecionado, Float> columnValorUni;
    @FXML
    private TableColumn<InsumoSelecionado, Boolean> checkBoxInsumo;
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
    private void visualizarTabela() {

        // Configuração básica das colunas
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnValorUni.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioInsumo"));

        // Configuração da coluna de CheckBox
        checkBoxInsumo.setCellFactory(tc -> new TableCell<>() {
            private final CheckBox checkBox = new CheckBox();

            {
                checkBox.setOnAction(event -> {
                    InsumoSelecionado insumoSelecionado = getTableView().getItems().get(getIndex());
                    insumoSelecionado.getBoxSelecionado().set(checkBox.isSelected());
                });
            }

            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    checkBox.setSelected(item != null && item);
                    setGraphic(checkBox);
                }
            }
        });
        checkBoxInsumo.setCellValueFactory(data -> data.getValue().getBoxSelecionado());

        // Configuração da coluna de TextField
        columnQntEstoque.setCellFactory(tc -> new TableCell<>() {
            private final TextField textField = new TextField();

            {
                textField.setOnKeyReleased(event -> {
                    InsumoSelecionado item = getTableView().getItems().get(getIndex());
                    try {
                        int value = Integer.parseInt(textField.getText());
                        item.setQntUsada(value);
                    } catch (NumberFormatException e) {
                        textField.setText("0");
                        item.setQntUsada(0);
                    }
                });
            }

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    textField.setText(String.valueOf(item)); // Define o valor do TextField
                    setGraphic(textField); // Exibe o TextField na célula
                }
            }
        });
        columnQntEstoque.setCellValueFactory(data -> data.getValue().getQntUsada().asObject());


        carregartabela();
    }

    private void carregartabela() {
        try {
            ObservableList<InsumoSelecionado> observableList = FXCollections.observableArrayList();
            for (Insumo insumo : httpInsumo.httpFindAllInsumo()) {
                observableList.add(new InsumoSelecionado(insumo));
            }
            tableViewInsumo.setItems(observableList);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar a tabela: " + e.getMessage(), e);
        }
    }


        @FXML
        public void addPapelaria() throws IOException, InterruptedException {


            List<InsumoSelecionado> insumosSelecionados = new ArrayList<>();


            for (InsumoSelecionado insumo : tableViewInsumo.getItems()) {
                if (insumo.getBoxSelecionado().get()) {
                    try {
                        int quantidadeUsada = insumo.getQntUsada().get();

                        insumo.setQntUsada(quantidadeUsada);
                        insumosSelecionados.add(insumo);
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter valor do TextField: " + e.getMessage());
                    }
                }
            }

            String nome = textFieldNome.getText();
            Integer qntEstoque = Integer.parseInt(textFieldQntEstoque.getText());
            Float precoPacote = Float.parseFloat(textFieldPrecoPacote.getText());
            Integer qntCadaPacote = Integer.parseInt(textFieldQntPacote.getText());
            Float lucro = Float.parseFloat(textFieldLucro.getText());
            Integer margem = Integer.parseInt(textFieldMargem.getText());

            Papelaria papelaria = new Papelaria(nome,qntEstoque,precoPacote,qntCadaPacote,lucro,margem);

            httpAddPapelaria.savePapelaria(papelaria);

            textFieldNome.clear();
            textFieldQntEstoque.clear();
            textFieldPrecoPacote.clear();
            textFieldQntPacote.clear();
            textFieldLucro.clear();
            textFieldMargem.clear();
            // Para fins de teste, exibe os dados coletados
            for (InsumoSelecionado selecionado : insumosSelecionados) {
                System.out.println("Nome: " + selecionado.getNome());
                System.out.println("Valor total do insumo: " + selecionado.getValorTotal());
            }
        }
public void initialize(URL url, ResourceBundle resourceBundle) {
    visualizarTabela();
    carregartabela();
}

}