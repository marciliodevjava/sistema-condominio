package br.com.morador.domain.enuns;

public enum EnumBloco {
    BLOCO_A(1),

    BLOCO_B(2),

    BLOCO_C(3),

    BLOCO_D(4),

    BLOCO_F(5),

    BLOCO_G(6),

    BLOCO_H(7),
    BLOC_IN(8);

    private final int valor;

    EnumBloco(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
