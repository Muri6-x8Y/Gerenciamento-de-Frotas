package com.motorista;



import com.App;
import com.Dao;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarMotoristasController {

    @FXML
    private TableView<Motorista> listaUsuarios;
    @FXML
    private TableColumn<Motorista, String> CnhColuna;
    @FXML
    private TableColumn<Motorista, String> NomeColuna;
    @FXML
    private TableColumn<Motorista, String> EnderecoColuna;
    @FXML
    private TableColumn<Motorista, String> SetorColuna;

    Dao<Motorista> dao = new Dao(Motorista.class);

    @FXML
    void initialize() {
        
        CnhColuna.setCellValueFactory(new PropertyValueFactory<>("CNH"));
        NomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
        EnderecoColuna.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        SetorColuna.setCellValueFactory(new PropertyValueFactory<>("setor"));

        List<Motorista> motoristas = dao.listarTodos();

        listaUsuarios.setItems(FXCollections.observableArrayList(motoristas));
    }

    @FXML
    private void Sair() throws IOException {
        App.setRoot("/com/telasImportantes/" + "menu");
    }

}
