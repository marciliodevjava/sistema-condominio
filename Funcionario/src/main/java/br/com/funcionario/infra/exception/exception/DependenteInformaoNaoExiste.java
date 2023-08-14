package br.com.funcionario.infra.exception.exception;

public class DependenteInformaoNaoExiste extends RuntimeException {

    public DependenteInformaoNaoExiste(){
        super();
    }

    public DependenteInformaoNaoExiste(String mensagem){
        super(mensagem);
    }

    public DependenteInformaoNaoExiste(String mensagem, Throwable couse){
        super(mensagem, couse);
    }
}
