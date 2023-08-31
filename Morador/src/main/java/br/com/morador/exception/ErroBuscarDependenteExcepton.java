package br.com.morador.exception;

public class ErroBuscarDependenteExcepton extends RuntimeException {
    public ErroBuscarDependenteExcepton(){
        super();
    }

    public ErroBuscarDependenteExcepton(String mensagem){
        super(mensagem);
    }

    public ErroBuscarDependenteExcepton(String mensagem, Throwable couse){
        super(mensagem, couse);
    }
}
