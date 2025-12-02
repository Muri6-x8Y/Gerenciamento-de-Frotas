package com.frota;

import com.App;
import com.Dao;
import com.veiculo.Veiculo;
import java.io.IOException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FrotaListar {

    @FXML
    private ComboBox<String> comboPlacas;

    @FXML
    private DatePicker campoData;

    @FXML
    private TableView<Retirada> tabela;

    @FXML
    private TableColumn<Retirada, String> colunaPlaca;

    @FXML
    private TableColumn<Retirada, String> colunaMotorista;

    @FXML
    private TableColumn<Retirada, LocalDate> colunaRetirada;

    @FXML
    private TableColumn<Retirada, LocalDate> colunaDevolucao;

    @FXML
    public void initialize() {

        Dao<Retirada> daoR = new Dao<>(Retirada.class);
        Dao<Veiculo> daoC = new Dao<>(Veiculo.class);

        comboPlacas.getItems().setAll(
            daoC.listarTodos()
                .stream()
                .map(Veiculo::getPlaca)
                .collect(Collectors.toList())
        );

        colunaPlaca.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
            c.getValue().getCarro().getPlaca()
        ));

        colunaMotorista.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
            c.getValue().getMotorista().getNome()
        ));

        colunaRetirada.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(
            c.getValue().getDataRetirada()
        ));

        colunaDevolucao.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(
            c.getValue().getDataDevolucao()
        ));

        atualizarTabelaCompleta();
    }

    private void atualizarTabelaCompleta() {
        Dao<Retirada> daoR = new Dao<>(Retirada.class);
        tabela.getItems().setAll(daoR.listarTodos());
    }

    @FXML
    public void filtrar() {

        Dao<Retirada> daoR = new Dao<>(Retirada.class);
        List<Retirada> lista = daoR.listarTodos();

        String placaSel = comboPlacas.getValue();
        LocalDate dataSel = campoData.getValue();

        List<Retirada> filtrados = lista.stream()
            .filter(r -> placaSel == null || placaSel.isEmpty() ||
                         r.getCarro().getPlaca().equalsIgnoreCase(placaSel))
            .filter(r -> dataSel == null ||
                         dataSel.equals(r.getDataRetirada()) ||
                         dataSel.equals(r.getDataDevolucao()))
            .collect(Collectors.toList());

        tabela.getItems().setAll(filtrados);
    }

    @FXML
    public void limparFiltros() {
        comboPlacas.setValue(null);
        campoData.setValue(null);
        atualizarTabelaCompleta();
    }
    
   public void voltar()throws IOException{
        App.setRoot("/com/telasImportantes/" + "menu");
        return;
    }
}
