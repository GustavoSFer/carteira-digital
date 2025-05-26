package br.com.fernandes.model;

import br.com.fernandes.entities.Conta;
import br.com.fernandes.entities.Usuario;
import br.com.fernandes.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContaModel {

    @Autowired
    ContaRepository contaRepository;

    public Conta criarConta(Conta conta, Usuario usuario) {
        conta.setUsuario(usuario);
        return contaRepository.save(conta);
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }
}
