package br.com.fernandes.controller;

import br.com.fernandes.controller.response.ApiResponse;
import br.com.fernandes.dto.ContaCreateDTO;
import br.com.fernandes.entities.Conta;
import br.com.fernandes.service.ContaServiceImpl;
import br.com.fernandes.service.interf.ContaInterf;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping(value = "/contas")
public class ContaController {

    @Autowired
    ContaInterf service;

    @PostMapping
    public ApiResponse<Conta> createConta(@RequestBody ContaCreateDTO conta) {
        Conta criaConta = new Conta();
        criaConta.setContaNumero(conta.contaNumero());
        criaConta.setContaAgencia(conta.contaAgencia());
        criaConta.setDac(conta.dac());
        criaConta.setUsuario(conta.usuario());

        Conta contaCriada = service.createConta(criaConta);

        return new ApiResponse<>(
                contaCriada,
                "/contas",
                Collections.emptyList()
        );
    }
}
