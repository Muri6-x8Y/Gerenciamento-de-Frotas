package com.motorista;

public class Motorista {
    String CNH;
    String nome;
    String endereco;
    String setor;

    public Motorista(String CNH, String nome, String endereco, String setor) {
        this.CNH = CNH;
        this.nome = nome;
        this.endereco = endereco;
        this.setor = setor;
    }

    public Motorista(){
        
    }
    
    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    // necessário para exibir o nome corretamente no ComboBox 
    @Override
    public String toString() {
        return nome; 
    }
}
