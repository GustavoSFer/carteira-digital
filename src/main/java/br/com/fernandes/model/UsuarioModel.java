package br.com.fernandes.model;

import br.com.fernandes.entities.Usuario;
import br.com.fernandes.exception.UserNotFound;
import br.com.fernandes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioModel {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> usuarios() { return usuarioRepository.findAll(); }

    public Optional<Usuario> findById(Long id) {
       Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario;
    }
}
