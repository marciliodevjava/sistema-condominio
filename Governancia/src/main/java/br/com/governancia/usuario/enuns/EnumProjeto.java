package br.com.governancia.usuario.enuns;

public enum EnumProjeto {
    GOVERNANCIA(1);

    private final int valor;

    EnumProjeto(int valor){
        this.valor=valor;
    }

    public int getValor() {
        return valor;
    }
}
