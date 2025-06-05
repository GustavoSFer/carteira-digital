package br.com.fernandes.service;

import br.com.fernandes.entities.Conta;
import br.com.fernandes.entities.Usuario;
import br.com.fernandes.exception.ContaNotFound;
import br.com.fernandes.model.ContaModel;
import br.com.fernandes.service.interf.ContaInterf;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ContaServiceImpl implements ContaInterf {

    @Autowired
    ContaModel contaModel;

    @Override
    public Conta createConta(Conta conta, Usuario usuario) {
        return contaModel.criarConta(conta, usuario);
    }

    @Override
    public List<Conta> getConta() {
        return contaModel.listarContas();
    }

    @Override
    public Conta contagetById(Long id) {
        Optional<Conta> conta = contaModel.buscarContaId(id);

        return conta.orElseThrow(() -> new ContaNotFound("Conta não encontrada!!!"));

    }

}
