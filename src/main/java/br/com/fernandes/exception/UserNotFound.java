package br.com.fernandes.exception;

public class UserNotFound extends RuntimeException {

    public UserNotFound(String msg) {
        super(msg);
    }
}
