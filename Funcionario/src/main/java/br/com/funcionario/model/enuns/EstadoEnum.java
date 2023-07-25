package br.com.funcionario.model.enuns;

public enum EstadoEnum {
    ATIVO(1),
    DESLIGADO(2),
    FERIAS(3),
    AFASTADO(4),
    SUSPENSO(5),
    FOLGA(6);

    private final int valor;

    EstadoEnum(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }
}
