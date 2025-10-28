package com;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarControler {
    
    @FXML 
    private TableView<Usuario> listaUsuarios;
    @FXML 
    private TableColumn<Usuario, String> LoginColuna;
    @FXML
    private TableColumn<Usuario, String> NomeColuna;
    @FXML
    private TableColumn<Usuario, String> SenhaColuna;
    
    Dao<Usuario> dao = new Dao(Usuario.class);    

    @FXML 
    void initialize(){
        LoginColuna.setCellValueFactory(new PropertyValueFactory<>("login"));
        NomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
        SenhaColuna.setCellValueFactory(new PropertyValueFactory<>("senha"));
        
        List<Usuario> usuarios = dao.listarTodos();
        
        listaUsuarios.setItems(FXCollections.observableArrayList(usuarios));
    }
        
}
