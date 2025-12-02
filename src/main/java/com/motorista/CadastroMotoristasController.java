package com.motorista;

import com.App;
import com.Dao;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class CadastroMotoristasController {
    @FXML
    private TextField campoCNH;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoEndereco;
    @FXML
    private TextField campoSetor;
    
    Dao<Motorista> dao = new Dao(Motorista.class);
    
    @FXML
    private void Cadastrar(){
        
        Motorista user = new Motorista();
        user.setNome(campoNome.getText());
        user.setCNH(campoCNH.getText());
        user.setEndereco(campoEndereco.getText());
        user.setSetor(campoSetor.getText());
        
        dao.inserir(user);
        campoCNH.clear(); 
        campoNome.clear(); 
        campoSetor.clear(); 
        campoEndereco.clear();         
    }
    
    @FXML
    private void Exit() throws IOException {
        App.setRoot("/com/telasImportantes/" + "menu");
    }
} 
