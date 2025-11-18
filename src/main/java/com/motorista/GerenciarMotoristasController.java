package com.motorista;

import com.App;
import com.Dao;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/*
 *  Precisei escrever as funções dos códigos pois já estava complexo e confuso
 */

public class GerenciarMotoristasController {

    @FXML
    private ComboBox<Motorista> comboMotoristas;

    @FXML
    private TextField txtCNH;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtSetor;

    private Dao<Motorista> dao = new Dao<>(Motorista.class);
    private ObservableList<Motorista> motoristas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Carrega todos os usuários do Mongo
        motoristas.addAll(dao.listarTodos());
        comboMotoristas.setItems(motoristas);

        // Atualiza campos ao selecionar usuário
        comboMotoristas.setOnAction(event -> {
            Motorista selecionado = comboMotoristas.getSelectionModel().getSelectedItem();
            carregarMotorista(selecionado);
        }); 
    }

    private void carregarMotorista(Motorista u) {
        if (u == null) return;
        txtCNH.setText(u.getCNH());
        txtNome.setText(u.getNome());
        txtEndereco.setText(u.getEndereco());
        txtSetor.setText(u.getSetor());
    }
    
    public void clearTxt(){
        txtCNH.clear();
        txtNome.clear();
        txtEndereco.clear();
        txtSetor.clear();

    }
    
    @FXML
    private void editarMotorista() {
        Motorista u = comboMotoristas.getSelectionModel().getSelectedItem();
        if (u == null) return;
        
        // Guardando o login antigo para quando atualizado o código funcionar para mais de um campo
        String nomeAntigo = u.getNome();

        
        // Atualiza os dados do usuário selecionado
        u.setCNH(txtCNH.getText());
        u.setNome(txtNome.getText());
        u.setEndereco(txtEndereco.getText());
        u.setSetor(txtSetor.getText());
        
        // Atualiza no banco
        dao.alterar("nome", nomeAntigo, u);

        // Força atualização da ComboBox
        comboMotoristas.setItems(null);
        comboMotoristas.setItems(FXCollections.observableArrayList(dao.listarTodos()));

        motoristas.setAll(dao.listarTodos());
        clearTxt();

        System.out.println("Motorista atualizado: " + u);
    }
    
    @FXML
    private void excluirMotorista() {
        Motorista u = comboMotoristas.getSelectionModel().getSelectedItem();
       
        if (u == null) return;
        // Exclui do banco
        dao.excluir("nome", u.getNome());

        // Remove da lista e limpa campos
        motoristas.remove(u);
        comboMotoristas.getSelectionModel().clearSelection();
        clearTxt();

        System.out.println("Motorista excluído: " + u);
    }
    
    @FXML
    private void sair() throws IOException{
        App.setRoot("menu");
    }
}