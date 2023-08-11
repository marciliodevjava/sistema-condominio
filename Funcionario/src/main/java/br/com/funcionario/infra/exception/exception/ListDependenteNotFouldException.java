package br.com.funcionario.infra.exception.exception;

public class ListDependenteNotFouldException extends RuntimeException {

    public ListDependenteNotFouldException() {
        super();
    }

    public ListDependenteNotFouldException(String mensagem) {
        super(mensagem);
    }

    public ListDependenteNotFouldException(String mensagem, Throwable couse) {
        super(mensagem, couse);
    }
}
