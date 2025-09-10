package br.com.fernandes.service.interf;

import br.com.fernandes.entities.Conta;
import br.com.fernandes.entities.Usuario;

import java.util.List;

public interface ContaInterf {

    Conta createConta(Conta conta);

    List<Conta> getConta();

    Conta contagetById(Long id);
}
