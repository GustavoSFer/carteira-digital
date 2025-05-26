package br.com.fernandes.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conta")
@Setter
@Getter
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

    @OneToMany(mappedBy = "contaOrigem")
    private List<Transacao> transacoesOrigem;

    @OneToMany(mappedBy = "contaDestino")
    private List<Transacao> transacoesDestino;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Conta() {}

    public Conta(String dac, String contaNumero, String contaAgencia) {
        this.dac = dac;
        this.contaNumero = contaNumero;
        this.contaAgencia = contaAgencia;
        this.transacoesOrigem = new ArrayList<>();
        this.transacoesDestino = new ArrayList<>();
    }
}
