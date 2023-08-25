package br.com.morador.exception;

public class ErroDeletarProprietarioException extends RuntimeException {
    public ErroDeletarProprietarioException(){
        super();
    }

    public ErroDeletarProprietarioException(String mensagem){
        super(mensagem);
    }

    public ErroDeletarProprietarioException(String mensagem, Throwable couse){
        super(mensagem, couse);
    }
}
