package com.frota;

import com.motorista.Motorista;
import com.veiculo.Veiculo;
import java.time.LocalDate;
import org.bson.types.ObjectId;

public class Retirada {

    private String id;
    private Veiculo carro;
    private Motorista motorista;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;
    private String status;

    public Retirada() {}

    public Retirada(Veiculo carro, Motorista motorista, LocalDate dataRetirada) {
        this.id = new ObjectId().toHexString();
        this.carro = carro;
        this.motorista = motorista;
        this.dataRetirada = dataRetirada;
        this.status = "EM_USO";
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Veiculo getCarro() { return carro; }
    public void setCarro(Veiculo carro) { this.carro = carro; }

    public Motorista getMotorista() { return motorista; }
    public void setMotorista(Motorista motorista) { this.motorista = motorista; }

    public LocalDate getDataRetirada() { return dataRetirada; }
    public void setDataRetirada(LocalDate dataRetirada) { this.dataRetirada = dataRetirada; }

    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return carro.getPlaca() + " | " + motorista.getNome() + " | " + dataRetirada;
    }
}
