package br.com.governancia.infra.exception.exception;

public class UsuarioNaoIdExisteException extends RuntimeException {
    public UsuarioNaoIdExisteException() {
        super();
    }

    public UsuarioNaoIdExisteException(String message) {
        super(message);
    }

    public UsuarioNaoIdExisteException(String message, Throwable cause) {
        super(message, cause);
    }
}
