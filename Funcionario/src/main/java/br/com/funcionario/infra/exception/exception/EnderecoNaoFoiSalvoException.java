package br.com.funcionario.infra.exception.exception;

public class EnderecoNaoFoiSalvoException extends RuntimeException {
    public EnderecoNaoFoiSalvoException(){
        super();
    }

    public EnderecoNaoFoiSalvoException(String mensagem){
        super(mensagem);
    }

    public EnderecoNaoFoiSalvoException(String mensagem, Throwable couse){
        super(mensagem, couse);
    }
}
