package br.com.morador.exception;

public class ErroSalvarApartamentoException extends RuntimeException {
    public ErroSalvarApartamentoException() {
        super();
    }

    public ErroSalvarApartamentoException(String mensagem) {
        super(mensagem);
    }

    public ErroSalvarApartamentoException(String mensagem, Throwable couse) {
        super(mensagem, couse);
    }
}
