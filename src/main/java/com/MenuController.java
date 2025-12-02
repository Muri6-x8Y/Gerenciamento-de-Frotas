package com;
import java.io.IOException;
import javafx.fxml.FXML;

public class MenuController {

     
    @FXML
    public void switchToCadastroUsuario() throws IOException {
        App.setRoot("/com/telasUsuarios/" + "cadastrarUsuarios");
    }
    
    public void switchToListarUsuario() throws IOException {
        App.setRoot("/com/telasUsuarios/" + "listarUsuarios");
    }
    
    public void switchToGerenciarUsuarios() throws IOException {
        App.setRoot("/com/telasUsuarios/" + "gerenciarUsuarios");
    }

    public void switchToCadastroMotorista() throws IOException {
        App.setRoot("/com/telasMotoristas/" + "cadastrarMotorista");
    }
    
    public void switchToListarMotoristas() throws IOException {
        App.setRoot("/com/telasMotoristas/" + "listarMotoristas");
    }

    public void switchToGerenciarMotoristas() throws IOException {
        App.setRoot("/com/telasMotoristas/" + "gerenciarMotoristas");
    }
    
    public void switchToCadastrarVeiculos() throws IOException {
        App.setRoot("/com/telasVeiculos/" + "cadastrarVeiculo");
    }

    public void switchToListarVeiculos() throws IOException {
        App.setRoot("/com/telasVeiculos/" + "listarVeiculos");
    }

    public void switchToGerenciarVeiculos() throws IOException {
        App.setRoot("/com/telasVeiculos/" + "gerenciarVeiculos");
    }
   
    public void switchToRegistrarRetirada() throws IOException {
        App.setRoot("/com/telasGerenciamentoDeFrotas/" + "telaRetirada");
    }
    
    public void switchToRegistrarDevolucao() throws IOException {
        App.setRoot("/com/telasGerenciamentoDeFrotas/" + "telaDevolucao");
    }
    
    public void switchToListarFrota () throws IOException {
        App.setRoot("/com/telasGerenciamentoDeFrotas/" + "telaListaFrota");
    }

}