package com;

import com.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class MenuController {

    
    
    @FXML
    public void switchToCadastroUsuario() throws IOException {
        App.setRoot("cadastroUsuario");
    }

    @FXML
    public void switchToCadastroOperador() throws IOException {
        App.setRoot("CadastroOperador");
    }
}