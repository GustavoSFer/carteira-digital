package br.com.fernandes.service;

import br.com.fernandes.entities.Usuario;
import br.com.fernandes.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioModel usuarioModel;

    public Usuario criaiUsuario(Usuario usuario) {
        return usuarioModel.criarUsuario(usuario);
    }
}
