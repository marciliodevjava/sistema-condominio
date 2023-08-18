package br.com.morador.exception;

public class ErroSalvarProprietarioException extends RuntimeException {
    public ErroSalvarProprietarioException() {
        super();
    }

    public ErroSalvarProprietarioException(String mensagem) {
        super(mensagem);
    }

    public ErroSalvarProprietarioException(String mensagem, Throwable couse) {
        super(mensagem, couse);
    }
}
