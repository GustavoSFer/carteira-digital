package br.com.fernandes.util;

import br.com.fernandes.dto.UsuarioDto;
import br.com.fernandes.entities.Usuario;

public class DtoMapper {

    public static UsuarioDto usuarioToDto(Usuario usuario) {
        UsuarioDto dto = new UsuarioDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getContas()
        );
        return dto;
    };
}
