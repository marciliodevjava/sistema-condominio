package br.com.funcionario.infra.exception.exception;

public class ErroDeletarFuncionarioException extends RuntimeException {
    public ErroDeletarFuncionarioException(){
        super();
    }
    public ErroDeletarFuncionarioException(String mensagem){
        super(mensagem);
    }
    public ErroDeletarFuncionarioException(String mensagem, Throwable cause){
        super(mensagem, cause);
    }
}
