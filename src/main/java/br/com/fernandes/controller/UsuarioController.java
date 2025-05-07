package br.com.fernandes.controller;

import br.com.fernandes.controller.response.ApiResponse;
import br.com.fernandes.dto.UsuarioCreateDTO;
import br.com.fernandes.dto.UsuarioDto;
import br.com.fernandes.entities.Usuario;
import br.com.fernandes.service.UsuarioServiceImpl;
import br.com.fernandes.util.DtoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioDto>> criarUsuario(@Valid @RequestBody UsuarioCreateDTO usuario) {

        Usuario usuarioCriado = usuarioService.criarUsuario(DtoMapper.usuarioCreateDTOToUsuario(usuario));
        UsuarioDto usuarioDto = DtoMapper.usuarioToDto(usuarioCriado);

        ApiResponse<UsuarioDto> response = new ApiResponse<>(
                usuarioDto,
                "/usuario",
                Collections.emptyList()
        );

        return ResponseEntity.ok().body(response);
    }
}
