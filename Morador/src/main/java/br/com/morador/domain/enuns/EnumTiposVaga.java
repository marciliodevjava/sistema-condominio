package br.com.morador.domain.enuns;

public enum EnumTiposVaga {
    CARRO(1),
    MOTO(2);

    private final int valor;

    EnumTiposVaga(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
