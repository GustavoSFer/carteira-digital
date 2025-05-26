package br.com.fernandes.dto;

import br.com.fernandes.entities.Conta;

import java.util.List;

public record UsuarioDto(
        Long id,
        String nome,
        String email,
        List<Conta> contas
) {
}
