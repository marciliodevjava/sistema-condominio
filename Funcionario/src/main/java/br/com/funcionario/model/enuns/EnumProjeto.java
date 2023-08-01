package br.com.funcionario.model.enuns;

public enum EnumProjeto {
    FUNCIONARIOR(1);

    private final int valor;

    EnumProjeto(int valor){
        this.valor=valor;
    }

    public int getValor() {
        return valor;
    }
}
