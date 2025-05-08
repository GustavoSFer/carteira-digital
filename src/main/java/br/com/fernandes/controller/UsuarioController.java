package br.com.fernandes.controller;

import br.com.fernandes.controller.response.ApiResponse;
import br.com.fernandes.dto.UsuarioCreateDTO;
import br.com.fernandes.dto.UsuarioDto;
import br.com.fernandes.entities.Usuario;
import br.com.fernandes.service.UsuarioServiceImpl;
import br.com.fernandes.util.DtoMapper;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioDto>> criarUsuario(@Valid @RequestBody UsuarioCreateDTO usuario) {

        Usuario usuarioCriado = usuarioService.criarUsuario(DtoMapper.usuarioCreateDTOToUsuario(usuario));
        UsuarioDto usuarioDto = DtoMapper.usuarioToDto(usuarioCriado);

        ApiResponse<UsuarioDto> response = new ApiResponse<>(
                usuarioDto,
                "/usuarios",
                Collections.emptyList()
        );

        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UsuarioDto>>> usuarios() {
        List<Usuario> usuarios = usuarioService.usuarios();
        List<UsuarioDto> usuariosDto = usuarios.stream().map(DtoMapper::usuarioToDto).toList();

        ApiResponse response = new ApiResponse(
                usuariosDto,
                "usuarios",
                Collections.emptyList()
        );
        return ResponseEntity.ok().body(response);
    }
}
