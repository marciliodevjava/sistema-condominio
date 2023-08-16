package br.com.morador.domain.enuns;

public enum EnumAndar {
    ANDAR_1(1),

    ANDAR_2(2),

    ANDAR_3(3),

    ANDAR_4(4),

    ANDAR_5(5),

    ANDAR_6(6),

    ANDAR_7(7),

    ANDAR_8(8),

    ANDAR_9(9),

    ANDAR_10(10),

    ANDAR_11(11),

    ANDAR_12(12),
    ANDAR_13(13),

    ANDAR_14(14),

    ANDAR_15(15),

    ANDAR_16(16),

    ANDAR_17(17),

    ANDAR_18(18);

    private final int valor;

    EnumAndar(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
