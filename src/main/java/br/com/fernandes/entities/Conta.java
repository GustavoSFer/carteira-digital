package br.com.fernandes.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Id;


import java.io.Serializable;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonProperty("contaAgencia")
    @NotNull(message = "O atributo conta agencia não pode ser nulo")
    private String contaAgencia;
    @JsonProperty("contaNumero")
    @NotNull(message = "O atributo conta número não pode ser nulo")
    private String contaNumero;
    @JsonProperty("dac")
    @NotNull(message = "O atributo dac não pode ser nulo")
    private String dac;

    public Conta() {}

    public Conta(String dac, String contaNumero, String contaAgencia) {
        this.dac = dac;
        this.contaNumero = contaNumero;
        this.contaAgencia = contaAgencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContaAgencia() {
        return contaAgencia;
    }

    public void setContaAgencia(String contaAgencia) {
        this.contaAgencia = contaAgencia;
    }

    public String getContaNumero() {
        return contaNumero;
    }

    public void setContaNumero(String contaNumero) {
        this.contaNumero = contaNumero;
    }

    public String getDac() {
        return dac;
    }

    public void setDac(String dac) {
        this.dac = dac;
    }
}
