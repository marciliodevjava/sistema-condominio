package br.com.funcionario.infra.exception.exception;

public class AtualizarDependenteNotFouldException extends RuntimeException {
    public AtualizarDependenteNotFouldException() {
        super();
    }

    public AtualizarDependenteNotFouldException(String mensagem) {
        super(mensagem);
    }

    public AtualizarDependenteNotFouldException(String mensagem, Throwable couse) {
        super(mensagem, couse);
    }
}
