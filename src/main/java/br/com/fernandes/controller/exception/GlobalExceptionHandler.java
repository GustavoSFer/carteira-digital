package br.com.fernandes.controller.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> argumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        Map<String, String> erros = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(error ->
                erros.put(error.getField(), error.getDefaultMessage())
        );
        Map<String, Object> corpoResposta = new HashMap<>();
        corpoResposta.put("data", new HashMap<>());
        corpoResposta.put("erros", erros);
        corpoResposta.put("paths", request.getRequestURI());

        return new ResponseEntity<>(corpoResposta, HttpStatus.BAD_REQUEST);
    };

}
