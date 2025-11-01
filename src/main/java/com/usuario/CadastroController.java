package com.usuario;

import com.App;
import com.Dao;
import com.Usuario;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class CadastroController {
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoLogin;
    @FXML
    private TextField campoSenha;
    
    Dao<Usuario> dao = new Dao(Usuario.class);
    
    @FXML
    private void Cadastrar(){
        
        Usuario user = new Usuario();
        user.setNome(campoNome.getText());
        user.setLogin(campoLogin.getText());
        user.setSenha(campoSenha.getText());
        
        dao.inserir(user);
        campoLogin.clear(); 
        campoNome.clear(); 
        campoSenha.clear(); 
        
        
    }
    
    @FXML
    private void Exit() throws IOException {
        App.setRoot("menu");
    }
    


}