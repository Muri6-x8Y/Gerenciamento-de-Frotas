package com.usuario;

import com.App;
import com.Dao;
import com.Usuario;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class CadastroController {
    @FXML
    private TextField campoCodigo;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoLogin;
    @FXML
    private TextField campoSenha;
    
    @FXML
    private void Cadastrar(){
        
        Usuario user = new Usuario();
        user.setCodigo(campoCodigo.getText());
        user.setNome(campoNome.getText());
        user.setLogin(campoLogin.getText());
        user.setNome(campoNome.getText());
        user.setSenha(campoSenha.getText());
        
        Dao<Usuario> dao = new Dao(Usuario.class);
        dao.inserir(user);
    }
    
    @FXML
    private void Exit() throws IOException {
        App.setRoot("menu");
    }
    


}