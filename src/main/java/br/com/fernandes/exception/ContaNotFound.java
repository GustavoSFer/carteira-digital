package br.com.fernandes.exception;

public class ContaNotFound extends RuntimeException{

    public ContaNotFound(String msg) {
        super(msg);
    }
}
