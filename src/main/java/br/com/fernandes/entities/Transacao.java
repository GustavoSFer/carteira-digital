package br.com.fernandes.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "transacao")
@Getter
@Setter
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("contaOrigem")
    @NotNull(message = "O atributo conta origem não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "conta_origem_id", referencedColumnName = "id")
    private Conta contaOrigem;

    @JsonProperty("contaDestino")
    @NotNull(message = "O atributo conta destino não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "conta_destino_id", referencedColumnName = "id")
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
}
