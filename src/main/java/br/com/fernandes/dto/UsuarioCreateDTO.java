package br.com.fernandes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCreateDTO(
        @JsonProperty("nome")
        @NotBlank(message = "O atributo nome não pode ser nulo")
         String nome,
         @JsonProperty("cpf")
        @NotBlank(message = "O atributo cpf não pode ser nulo")
        String cpf,
        @JsonProperty("email")
        @NotBlank(message = "O atributo email não pode ser nulo")
        String email,
        @JsonProperty("senha")
        @NotBlank(message = "A senha é obrigatória e não pode estar vazia")
        @Size(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
        String senha
) {
}
