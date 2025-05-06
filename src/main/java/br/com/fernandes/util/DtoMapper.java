package br.com.fernandes.util;

import br.com.fernandes.dto.UsuarioCreateDTO;
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

    public static Usuario usuarioCreateDTOToUsuario(UsuarioCreateDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.nome());
        usuario.setCpf(usuarioDTO.cpf());
        usuario.setEmail(usuarioDTO.email());
        usuario.setSenha(usuarioDTO.senha());
        return usuario;
    };
}
