package br.com.morador.domain.enuns;

public enum EnumSetorVaga {
    SETOR_A(1),
    SETOR_B(2),
    SETOR_C(3),
    SETOR_D(4),
    SETOR_E(5),
    SETOR_F(6),
    SETOR_SUB_SOLO_A(7),
    SETOR_SUB_SOLO_B(8),
    SETOR_SUB_SOLO_C(9),
    SETOR_SUB_SOLO_D(10);

    private final int valor;

    EnumSetorVaga(int valor){
        this.valor=valor;
    }

    public int getValor() {
        return valor;
    }
}
