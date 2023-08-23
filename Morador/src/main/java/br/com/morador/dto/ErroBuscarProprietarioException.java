package br.com.morador.dto;

public class ErroBuscarProprietarioException extends RuntimeException {
    public ErroBuscarProprietarioException() {
        super();
    }

    public ErroBuscarProprietarioException(String mensagem) {
        super(mensagem);
    }

    public ErroBuscarProprietarioException(String mensagem, Throwable couse) {
        super(mensagem, couse);
    }
}
