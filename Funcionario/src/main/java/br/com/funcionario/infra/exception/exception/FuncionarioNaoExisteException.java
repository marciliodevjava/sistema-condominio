package br.com.funcionario.infra.exception.exception;

public class FuncionarioNaoExisteException extends RuntimeException {
    public FuncionarioNaoExisteException() {
        super();
    }

    public FuncionarioNaoExisteException(String mensagem) {
        super(mensagem);
    }

    public FuncionarioNaoExisteException(String mensagem, Throwable couse) {
        super(mensagem, couse);
    }
}
