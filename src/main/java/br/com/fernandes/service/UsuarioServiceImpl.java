package br.com.fernandes.service;

import br.com.fernandes.entities.Usuario;
import br.com.fernandes.exception.UserNotFound;
import br.com.fernandes.model.UsuarioModel;
import br.com.fernandes.service.interf.UsuarioInterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioInterf {

    @Autowired
    private UsuarioModel usuarioModel;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioModel.criarUsuario(usuario);
    }

    @Override
    public List<Usuario> usuarios() {
        return usuarioModel.usuarios();
    }

    @Override
    public Optional<Usuario> getUsuario(long id) {
        Optional<Usuario> usuario = usuarioModel.findById(id);
        return Optional.ofNullable(usuario.orElseThrow(() -> new UserNotFound("Usuário não encontrado")));
    }
}
