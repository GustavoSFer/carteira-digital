package br.com.fernandes.service.interf;

import br.com.fernandes.entities.Usuario;

import java.util.List;

public interface UsuarioInterf {

    Usuario criarUsuario(Usuario usuario);

    List<Usuario> usuarios();

}
