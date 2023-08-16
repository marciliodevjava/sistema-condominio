package br.com.morador.domain.enuns;

public enum EnumProjeto {
    MORADOR(1);

    private final int valor;

    EnumProjeto(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
