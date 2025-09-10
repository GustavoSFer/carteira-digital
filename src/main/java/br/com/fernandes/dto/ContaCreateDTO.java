package br.com.fernandes.dto;

import br.com.fernandes.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record ContaCreateDTO(
        @JsonProperty("contaAgencia")
        @NotNull(message = "O atributo conta agencia não pode ser nulo")
        String contaAgencia,

        @JsonProperty("contaNumero")
        @NotNull(message = "O atributo conta número não pode ser nulo")
        String contaNumero,

        @JsonProperty("dac")
        @NotNull(message = "O atributo dac não pode ser nulo")
        String dac,

        @JsonProperty("usuario")
        @NotNull(message = "O atributo dac não pode ser nulo")
        Usuario usuario
) {
}
