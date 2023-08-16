package br.com.morador.domain.enuns;

public enum EnumSexo {
    MASCULINO(1),
    FEMININO(2),
    NAO_DEFINIDO(3);

    private final int valor;

    EnumSexo(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
