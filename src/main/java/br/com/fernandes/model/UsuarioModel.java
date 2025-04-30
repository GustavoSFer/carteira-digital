package br.com.fernandes.model;

import br.com.fernandes.entities.Usuario;
import br.com.fernandes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioModel {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
