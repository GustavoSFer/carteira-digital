package br.com.fernandes.service;

import br.com.fernandes.entities.Usuario;
import br.com.fernandes.model.UsuarioModel;
import br.com.fernandes.service.interf.UsuarioInterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioInterf {

    @Autowired
    private UsuarioModel usuarioModel;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioModel.criarUsuario(usuario);
    }
}
