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
import java.util.ResourceBundle;

@Controller
public class ControllerAddPapelaria implements Initializable {

    //Tabela
    @FXML
    private TableView<InsumoSelecionado> tableViewInsumo;

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
        columnValorUni.setCellValueFactory(new PropertyValueFactory<>("valorTotalEstoque"));

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
                textField.setOnAction(event -> {
                    InsumoSelecionado item = getTableView().getItems().get(getIndex());
                    try {
                        int value = Integer.parseInt(textField.getText());
                        item.getQntUsada().set(value);
                    } catch (NumberFormatException e) {
                        textField.setText("0");
                        item.getQntUsada().set(0);
                    }
                });
            }

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    textField.setText(item == null ? "0" : String.valueOf(item));
                    setGraphic(textField);
                }
            }
        });
        columnQntEstoque.setCellValueFactory(data -> data.getValue().getQntUsada().asObject());

        // Adicionar as colunas à tabela (apenas se forem adicionadas dinamicamente)
        if (!tableViewInsumo.getColumns().contains(columnQntEstoque)) {
            tableViewInsumo.getColumns().add(columnQntEstoque);
        }

        // Carregar os dados na tabela
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

    /*
@FXML
public void visualizarTabela() {
    // Configuração básica das colunas
    columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    columnValorUni.setCellValueFactory(new PropertyValueFactory<>("valorTotalEstoque"));
    columnQntEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));

    checkBoxInsumo.setCellFactory(tc -> new TableCell<InsumoSelecionado, Boolean>() {
        private final CheckBox checkBox = new CheckBox();{
            checkBox.setOnAction(event -> {
                InsumoSelecionado insumoSelecionado = getTableView().getItems().get(getIndex());
                insumoSelecionado.getBoxSelecionado().set(checkBox.isSelected());
            });
        }
    }
    );
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

    visualizarTabela();
    textFieldNome.clear();
    textFieldLucro.clear();
    textFieldMargem.clear();
    textFieldQntPacote.clear();
    textFieldQntEstoque.clear();
    textFieldPrecoPacote.clear();
}


 */
public void initialize(URL url, ResourceBundle resourceBundle) {
    visualizarTabela();
    carregartabela();
}

}