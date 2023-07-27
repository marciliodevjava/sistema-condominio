package br.com.gerador.domain.enuns;

public enum EnumAtivo {
    ATIVO(1),
    INATIVO(2);

    private final int valor;

    EnumAtivo(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
