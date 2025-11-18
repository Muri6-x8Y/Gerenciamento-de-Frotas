package com;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class listarVeiculosController {

    @FXML
    private TableView<Veiculo> listaVeiculos;
    @FXML
    private TableColumn<Veiculo, String> placaColuna;
    @FXML
    private TableColumn<Veiculo, String> marcaColuna;
    @FXML
    private TableColumn<Veiculo, String> modeloColuna;

    Dao<Veiculo> dao = new Dao(Veiculo.class);

    @FXML
    void initialize() {
        placaColuna.setCellValueFactory(new PropertyValueFactory<>("placa"));
        marcaColuna.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloColuna.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        List<Veiculo> veiculos = dao.listarTodos();

        listaVeiculos.setItems(FXCollections.observableArrayList(veiculos));
    }

    @FXML
    private void Sair() throws IOException {
        App.setRoot("menu");
    }

}
