package br.com.morador.dto;

public class ErroSalvarDependenteException extends RuntimeException {
    public ErroSalvarDependenteException(){
        super();
    }

    public ErroSalvarDependenteException(String mensagem){
        super(mensagem);
    }

    public ErroSalvarDependenteException(String mensagem, Throwable couse){
        super(mensagem, couse);
    }
}
