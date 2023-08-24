package br.com.morador.exception;

public class ErroUuidInvalidoException extends RuntimeException {
    public ErroUuidInvalidoException() {
        super();
    }

    public ErroUuidInvalidoException(String mensagem) {
        super(mensagem);
    }

    public ErroUuidInvalidoException(String mensagem, Throwable couse) {
        super(mensagem, couse);
    }
}
