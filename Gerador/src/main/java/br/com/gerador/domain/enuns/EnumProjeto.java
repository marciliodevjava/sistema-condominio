package br.com.gerador.domain.enuns;

public enum EnumProjeto {
    GERADOR(1);

    private final int valor;

    EnumProjeto(int valor){
        this.valor=valor;
    }

    public int getValor() {
        return valor;
    }
}
