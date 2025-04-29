package br.com.fernandes.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "transacao")
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonProperty("contaOrigem")
    @NotNull(message = "O atributo conta origem não pode ser nulo")
    private Conta contaOrigem;
    @JsonProperty("contaDestino")
    @NotNull(message = "O atributo conta destino não pode ser nulo")
    private Conta contaDestino;
    @JsonProperty("valor")
    @NotNull(message = "O atributo valor não pode ser nulo")
    private double valor;

    public Transacao(){};

    public Transacao(Conta contaOrigem, Conta contaDestino, double valor) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
