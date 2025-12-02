package com;

import com.usuario.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.List;

public class LoginController {

    @FXML
    private TextField campoLogin;

    @FXML
    private PasswordField campoSenha;

    private Dao<Usuario> dao = new Dao<>(Usuario.class);

    @FXML
    private void logar() throws IOException {
        String login = campoLogin.getText();
        String senha = campoSenha.getText();

        // esse "admin/admin" não entraria na produção mas está ai só pra dar uma testada e descontraida
        if (login.equals("admin") && senha.equals("admin")) {
            App.setRoot("/com/telasImportantes/" + "menu");
            return;
        }

        List<Usuario> usuarios = dao.filtrar("login", login);

        if (!usuarios.isEmpty()) {
            Usuario u = usuarios.get(0);

            if (u.getSenha().equals(senha)) {
                App.setRoot("/com/telasImportantes/" + "menu");
                return;
            }
        }

       
        alerta("Erro", "Login ou senha incorretos!");
        campoSenha.clear();
    }

    private void alerta(String titulo, String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
