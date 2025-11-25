package com.veiculo;

import com.App;
import com.Dao;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class CadastroVeiculosController {
    @FXML
    private TextField campoPlaca;
    @FXML
    private TextField campoMarca;
    @FXML
    private TextField campoModelo;
    
    Dao<Veiculo> dao = new Dao(Veiculo.class);
    
    @FXML
    private void Cadastrar(){
        
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(campoPlaca.getText());
        veiculo.setMarca(campoMarca.getText());
        veiculo.setModelo(campoModelo.getText());
        
        dao.inserir(veiculo);
        campoPlaca.clear(); 
        campoMarca.clear(); 
        campoModelo.clear(); 
        
        
    }
    
    @FXML
    private void Exit() throws IOException {
        App.setRoot("menu");
    }
    


}