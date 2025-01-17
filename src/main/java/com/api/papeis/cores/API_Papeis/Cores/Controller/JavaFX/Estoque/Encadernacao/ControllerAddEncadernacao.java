package com.api.papeis.cores.API_Papeis.Cores.Controller.JavaFX.Estoque.Encadernacao;

import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Encadernacao.HttpEncadernacao;
import com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Insumo.HttpInsumo;
import com.api.papeis.cores.API_Papeis.Cores.MainApplication;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Encadernacao.Encadernacao;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo.InsumoSelecionado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
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
    private TableColumn<InsumoSelecionado, Integer> tableColumnValorUni;
    @FXML
    private TableColumn<InsumoSelecionado, Boolean>checkBoxInsumo;
    @FXML
    private TableColumn<InsumoSelecionado, Integer> columnQntEstoque;

    @FXML
    public void CenaInicial(ActionEvent event){
        try {
            MainApplication.trocaCena("/templates/View/MenuEncadernacao.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void visualizarTabela(){
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnValorUni.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioInsumo"));

        checkBoxInsumo.setCellFactory(tc -> new TableCell<InsumoSelecionado, Boolean>() {
            private final CheckBox checkBox = new CheckBox();

            {
                checkBox.setOnAction(event -> {
                    InsumoSelecionado selecionado = getTableView().getItems().get(getIndex());
                    if (selecionado != null) {
                        selecionado.getBoxSelecionado().set(checkBox.isSelected());
                    }
                });
            }

            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    checkBox.setSelected(item);
                    setGraphic(checkBox);
                }
            }
        });

        checkBoxInsumo.setCellValueFactory(data -> data.getValue().getBoxSelecionado());

        columnQntEstoque.setCellFactory(tc -> new TableCell<InsumoSelecionado, Integer>() {
            private final TextField textField = new TextField();

            {
                textField.setOnKeyReleased(event -> {
                    InsumoSelecionado item = getTableView().getItems().get(getIndex());
                    if (item != null) {
                        try {
                            int value = Integer.parseInt(textField.getText());
                            item.setQntUsada(value);
                        } catch (NumberFormatException e) {
                            textField.setText("0");
                            item.setQntUsada(0);
                        }
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
    }
    public void addEncadernacao(){
        String nome = textFieldNome.getText();
        Integer qntEstoque = Integer.parseInt(textFieldQntEstoque.getText());
        Double lucro = Double.parseDouble(textFieldLucro.getText());
        Double margem = Double.parseDouble(textFieldMargem.getText());


        //Falta pegar a quantidade do insumo
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
