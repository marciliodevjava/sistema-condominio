package br.com.funcionario.model.enuns;

public enum GrauParentescoEnum {
    PAI(1),
    MAE(2),
    AVO_HOMEM(3),
    AVO_MULHER(4),
    BISAVO_HOMEM(5),
    BISAVO_MULHER(6),
    FILHO(7),
    FILHA(8),
    BISNETO(9),
    BISNETA(10),
    ENTIADO(11),
    ENTIADA(12);

    private final int valor;

    GrauParentescoEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
