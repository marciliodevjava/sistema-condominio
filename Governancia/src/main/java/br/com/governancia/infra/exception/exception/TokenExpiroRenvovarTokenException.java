package br.com.governancia.infra.exception.exception;

public class TokenExpiroRenvovarTokenException extends RuntimeException {
    public TokenExpiroRenvovarTokenException() {
        super();
    }

    public TokenExpiroRenvovarTokenException(String message) {
        super(message);
    }

    public TokenExpiroRenvovarTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}

