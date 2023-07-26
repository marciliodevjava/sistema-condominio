package br.com.funcionario.model.enuns;

public enum EstadoCivilEnum {

    SOLTEIRO(1),
    CASADO(2),
    SEPARADO(3),
    DIVORCIADO(4),
    VIUVI(5);
    private final int valor;

    EstadoCivilEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
