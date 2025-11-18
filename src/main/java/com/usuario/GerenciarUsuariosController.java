package com.usuario;

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

public class GerenciarUsuariosController {

    @FXML
    private ComboBox<Usuario> comboUsuarios;

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtSenha;

    private Dao<Usuario> dao = new Dao<>(Usuario.class);
    private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Carrega todos os usuários do Mongo
        usuarios.addAll(dao.listarTodos());
        comboUsuarios.setItems(usuarios);

        // Atualiza campos ao selecionar usuário
        comboUsuarios.setOnAction(event -> {
            Usuario selecionado = comboUsuarios.getSelectionModel().getSelectedItem();
            carregarUsuario(selecionado);
        }); 
    }

    private void carregarUsuario(Usuario u) {
        if (u == null) return;
        txtNome.setText(u.getNome());
        txtLogin.setText(u.getLogin());
        txtSenha.setText(u.getSenha());
    }
    
    @FXML
    private void editarUsuario() {
        Usuario u = comboUsuarios.getSelectionModel().getSelectedItem();
        if (u == null) return;
        
        // Guardando o login antigo para quando atualizado o código funcionar para mais de um campo
        String loginAntigo = u.getLogin();

        
        // Atualiza os dados do usuário selecionado
        u.setNome(txtNome.getText());
        u.setLogin(txtLogin.getText());
        u.setSenha(txtSenha.getText());

        // Atualiza no banco
        dao.alterar("login", loginAntigo, u);

        // Força atualização da ComboBox
        comboUsuarios.setItems(null);
        comboUsuarios.setItems(FXCollections.observableArrayList(dao.listarTodos()));

        System.out.println("Usuário atualizado: " + u);
    }
    
    @FXML
    private void excluirUsuario() {
        Usuario u = comboUsuarios.getSelectionModel().getSelectedItem();
       
        if (u == null) return;
        // Exclui do banco
        dao.excluir("login", u.getLogin());

        // Remove da lista e limpa campos
        usuarios.remove(u);
        comboUsuarios.getSelectionModel().clearSelection();
        txtNome.clear();
        txtLogin.clear();
        txtSenha.clear();

        System.out.println("Usuário excluído: " + u);
    }
    
    @FXML
    private void sair() throws IOException{
        App.setRoot("menu");
    }
}