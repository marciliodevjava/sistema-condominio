package br.com.governancia.infra.exception.exception;

public class UsuarioNaoExisteException extends RuntimeException {
    public UsuarioNaoExisteException() {
        super();
    }

    public UsuarioNaoExisteException(String message) {
        super(message);
    }

    public UsuarioNaoExisteException(String message, Throwable cause) {
        super(message, cause);
    }
}
