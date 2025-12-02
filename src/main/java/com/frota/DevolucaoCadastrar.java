package com.frota;

import com.App;
import com.Dao;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class DevolucaoCadastrar{

    @FXML
    private ComboBox<Retirada> comboRetiradas;

    @FXML
    private DatePicker campoData;

    @FXML
    public void initialize() {
        Dao<Retirada> daoR = new Dao<>(Retirada.class);
        comboRetiradas.getItems().setAll(daoR.filtrar("status", "EM_USO"));
    }

    @FXML
    public void devolver() {

        Retirada retirada = comboRetiradas.getValue();
        LocalDate data = campoData.getValue();

        if (retirada == null || data == null) {
            alerta("Erro", "Preencha todos os campos!");
            return;
        }

        retirada.setDataDevolucao(data);
        retirada.setStatus("DEVOLVIDO");

        Dao<Retirada> daoR = new Dao<>(Retirada.class);
        daoR.alterar("_id", retirada.getId(), retirada);

        alerta("Sucesso", "Veículo devolvido!");

        limpar();
    }

    @FXML
    public void limpar() {
        comboRetiradas.setValue(null);
        campoData.setValue(null);

        Dao<Retirada> daoR = new Dao<>(Retirada.class);
        comboRetiradas.getItems().setAll(daoR.filtrar("status", "EM_USO"));
    }
    
    public void voltar()throws IOException{
        App.setRoot("menu");
        return;
    }

    private void alerta(String titulo, String msg){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.show();
    }
}
