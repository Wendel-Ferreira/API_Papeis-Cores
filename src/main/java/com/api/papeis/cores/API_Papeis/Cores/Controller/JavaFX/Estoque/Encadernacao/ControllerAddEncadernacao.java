package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Encadernacao;

import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Encadernacao.HttpEncadernacao;
import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Insumo.HttpInsumo;
import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Encadernacao.Encadernacao;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo.Insumo;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo.InsumoSelecionado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class ControllerAddEncadernacao implements Initializable {

    @Autowired
    private HttpEncadernacao httpEncadernacao;
    @Autowired
    private HttpInsumo httpInsumo;

    private InsumoSelecionado insumoSelecionado;

    @FXML
    private Button buttonAdd;
    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldQntEstoque;
    @FXML
    private TextField textFieldLucro;
    @FXML
    private TextField textFieldMargem;

    //Tabela
    @FXML
    private TableView<InsumoSelecionado> tableViewInsumo;
    @FXML
    private TableColumn<InsumoSelecionado, String> tableColumnNome;
    @FXML
    private TableColumn<InsumoSelecionado, Integer> tableColumnPrecoTotal;
    @FXML
    private TableColumn<InsumoSelecionado, Boolean> checkBoxInsumo;
    @FXML
    private TableColumn<InsumoSelecionado, Integer> columnQntEstoque;

    @FXML
    public void menuPapelaria(ActionEvent event) {
        try {
            MainApplication.trocaCena("/templates/View/Estoque/Encadernacao/MenuEncadernacao.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void visualizarTabela() {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));

        checkBoxInsumo.setCellFactory(tc -> new TableCell<>() {
            private final CheckBox checkBox = new CheckBox();

            {
                checkBox.setOnAction(event -> {
                    InsumoSelecionado insumoSelecionado = getTableView().getItems().get(getIndex());
                    if (insumoSelecionado != null) {
                        insumoSelecionado.getBoxSelecionado().set(checkBox.isSelected());
                    }
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
                    textField.setText(String.valueOf(item));
                    setGraphic(textField);
                }
            }
        });

        columnQntEstoque.setCellValueFactory(data -> data.getValue().getQntUsada().asObject());
        carregarTabela();
    }

    public void addEncadernacao() {
        List<InsumoSelecionado> insumoSelecionados = new ArrayList<>();

        for (InsumoSelecionado insumo : tableViewInsumo.getItems()) {
            if (insumo.getBoxSelecionado().get()) {
                try {
                    int quantidadeUsada = insumo.getQntUsada().get();
                    insumo.setQntUsada(quantidadeUsada);
                    insumoSelecionados.add(insumo);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        String nome = textFieldNome.getText();
        Integer qntEstoque = Integer.parseInt(textFieldQntEstoque.getText());
        //precoPacote

        Double lucro = Double.parseDouble(textFieldLucro.getText());
        Double margem = Double.parseDouble(textFieldMargem.getText());


        //Falta pegar a quantidade do insumo
    }

    public void carregarTabela() {
        try {
            ObservableList<InsumoSelecionado> observableList = FXCollections.observableArrayList();
            for (Insumo insumo : httpInsumo.httpFindAllInsumo()) {
                observableList.add(new InsumoSelecionado(insumo));
            }
            tableViewInsumo.setItems(observableList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        visualizarTabela();
        carregarTabela();
    }
}
