package com.ergo.ergonomic.usuario.app;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException() {
        super();
    }
    public UsuarioNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
    public UsuarioNaoEncontradoException(Throwable cause) {
        super(cause);
    }

}
