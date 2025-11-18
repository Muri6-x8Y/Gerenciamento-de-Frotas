package com;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/*
 *  Precisei escrever as funções dos códigos pois já estava complexo e confuso
 */

public class GerenciarVeiculosController {

    @FXML
    private ComboBox<Veiculo> comboVeiculos;

    @FXML
    private TextField txtPlaca;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtSetor;

    private Dao<Veiculo> dao = new Dao<>(Veiculo.class);
    private ObservableList<Veiculo> veiculos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Carrega todos os usuários do Mongo
        veiculos.addAll(dao.listarTodos());
        comboVeiculos.setItems(veiculos);

        // Atualiza campos ao selecionar usuário
        comboVeiculos.setOnAction(event -> {
            Veiculo selecionado = comboVeiculos.getSelectionModel().getSelectedItem();
            carregarVeiculo(selecionado);
        }); 
    }

    private void carregarVeiculo (Veiculo u) {
        if (u == null) return;
        txtPlaca.setText(u.getPlaca());
        txtMarca.setText(u.getMarca());
        txtModelo.setText(u.getModelo());
    }
    
    public void clearTxt(){
        txtPlaca.clear();
        txtMarca.clear();
        txtModelo.clear();
        
    }
    
    @FXML
    private void editarVeiculo() {
        Veiculo u = comboVeiculos.getSelectionModel().getSelectedItem();
        if (u == null) return;
        
        // Guardando o login antigo para quando atualizado o código funcionar para mais de um campo
        String placaAntiga = u.getPlaca();

        
        // Atualiza os dados do usuário selecionado
        u.setPlaca(txtPlaca.getText());
        u.setMarca(txtMarca.getText());
        u.setModelo(txtModelo.getText());
        
        
        // Atualiza no banco
        dao.alterar("placa", placaAntiga, u);

        // Força atualização da ComboBox
        comboVeiculos.setItems(null);
        comboVeiculos.setItems(FXCollections.observableArrayList(dao.listarTodos()));

        veiculos.setAll(dao.listarTodos());
        clearTxt();

        System.out.println("Veiculo atualizado: " + u);
    }
    
    @FXML
    private void excluirVeiculo() {
        Veiculo u = comboVeiculos.getSelectionModel().getSelectedItem();
       
        if (u == null) return;
        // Exclui do banco
        dao.excluir("placa", u.getPlaca());

        // Remove da lista e limpa campos
        veiculos.remove(u);
        comboVeiculos.getSelectionModel().clearSelection();
        clearTxt();

        System.out.println("Veiculo excluído: " + u);
    }
    
    @FXML
    private void sair() throws IOException{ 
        App.setRoot("menu");
    }
}