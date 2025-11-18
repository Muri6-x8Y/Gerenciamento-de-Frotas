package com;
import java.io.IOException;
import javafx.fxml.FXML;

public class MenuController {

     
    @FXML
    public void switchToCadastroUsuario() throws IOException {
        App.setRoot("/com/telasUsuarios/" + "cadastroUsuarios");
    }
    
    public void switchToListarUsuario() throws IOException {
        App.setRoot("/com/telasUsuarios/" + "listarUsuarios");
    }
    
    public void switchToGerenciarUsuarios() throws IOException {
        App.setRoot("/com/telasUsuarios/" + "gerenciarUsuarios");
    }

    public void switchToCadastroMotorista() throws IOException {
        App.setRoot("/com/telasMotoristas/" + "cadastroMotorista");
    }
    
    public void switchToListarMotoristas() throws IOException {
        App.setRoot("/com/telasMotoristas/" + "listarMotoristas");
    }

    public void switchToGerenciarMotoristas() throws IOException {
        App.setRoot("/com/telasMotoristas/" + "gerenciarMotoristas");
    }
    
    
    

}