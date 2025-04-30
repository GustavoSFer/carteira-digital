package br.com.fernandes.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("nome")
    @NotNull(message = "O atributo nome não pode ser nulo")
    private String nome;
    @JsonProperty("cpf")
    @NotNull(message = "O atributo cpf não pode ser nulo")
    private String cpf;
    @JsonProperty("email")
    @NotNull(message = "O atributo email não pode ser nulo")
    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conta> contas;

    public Usuario() {}

    public Usuario(Long id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.contas = new ArrayList<>();
    }
}
