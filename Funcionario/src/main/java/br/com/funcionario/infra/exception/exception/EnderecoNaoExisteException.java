package br.com.funcionario.infra.exception.exception;

public class EnderecoNaoExisteException extends RuntimeException {
    public EnderecoNaoExisteException() {
        super();
    }

    public EnderecoNaoExisteException(String mensagem) {
        super(mensagem);
    }

    public EnderecoNaoExisteException(String mensagem, Throwable couse) {
        super(mensagem, couse);
    }
}
