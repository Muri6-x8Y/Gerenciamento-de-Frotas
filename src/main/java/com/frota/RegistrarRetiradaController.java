package com.frota;

import com.App;
import com.Dao;
import com.veiculo.Veiculo;
import com.motorista.Motorista;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import java.util.List;

public class RegistrarRetiradaController {

    @FXML
    private ComboBox<Veiculo> comboCarro;

    @FXML
    private ComboBox<Motorista> comboMotorista;

    @FXML
    private DatePicker campoData;

    @FXML
    public void initialize() {
        atualizarListas(); // carrega logo ao abrir
    }

private void atualizarListas() {
    Dao<Veiculo> daoC = new Dao<>(Veiculo.class);
    Dao<Motorista> daoM = new Dao<>(Motorista.class);
    Dao<Retirada> daoR = new Dao<>(Retirada.class);

    List<Retirada> emUso = daoR.filtrar("status", "EM_USO");

    List<Veiculo> todosCarros = daoC.listarTodos();
    List<Motorista> todosMotoristas = daoM.listarTodos();

    List<Veiculo> livresCarro = new java.util.ArrayList<>();
    List<Motorista> livresMotorista = new java.util.ArrayList<>();

    // Verifica carros disponíveis
    for (Veiculo v : todosCarros) {
        boolean ocupado = false;
        for (Retirada r : emUso) {
            if (r.getCarro() != null && r.getCarro().getPlaca().equals(v.getPlaca())) {
                ocupado = true;
                break;
            }
        }
        if (!ocupado) {
            livresCarro.add(v);
        }
    }

    // Verifica motoristas disponíveis
    for (Motorista m : todosMotoristas) {
        boolean ocupado = false;
        for (Retirada r : emUso) {
            if (r.getMotorista() != null && r.getMotorista().getCNH().equals(m.getCNH())) {
                ocupado = true;
                break;
            }
        }
        if (!ocupado) {
            livresMotorista.add(m);
        }
    }

    comboCarro.getItems().setAll(livresCarro);
    comboMotorista.getItems().setAll(livresMotorista);

    comboCarro.getSelectionModel().clearSelection();
    comboMotorista.getSelectionModel().clearSelection();
}

    @FXML
    public void registrar() {

        Veiculo carro = comboCarro.getValue();
        Motorista motorista = comboMotorista.getValue();
        LocalDate data = campoData.getValue();

        if (carro == null || motorista == null || data == null) {
            alerta("Erro", "Preencha todos os campos!");
            return;
        }

        Dao<Retirada> daoR = new Dao<>(Retirada.class);
        Retirada ret = new Retirada(carro, motorista, data);
        daoR.inserir(ret);

        alerta("Sucesso", "Retirada registrada!");

        limpar();           
        atualizarListas();  
    }

    @FXML
    public void limpar() {
        comboCarro.setValue(null);
        comboMotorista.setValue(null);
        campoData.setValue(null);
    }

    public void voltar() throws IOException {
        App.setRoot("menu");
    }

    private void alerta(String titulo, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.show();
    }
}
