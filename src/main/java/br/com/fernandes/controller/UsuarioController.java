package br.com.fernandes.controller;

import br.com.fernandes.dto.UsuarioDto;
import br.com.fernandes.entities.Usuario;
import br.com.fernandes.model.UsuarioModel;
import br.com.fernandes.service.UsuarioService;
import br.com.fernandes.util.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criar")
    public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCriado = usuarioService.criaiUsuario(usuario);

        return ResponseEntity.ok().body(DtoMapper.usuarioToDto(usuarioCriado));
    }
}
