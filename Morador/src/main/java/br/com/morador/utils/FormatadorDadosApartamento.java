package br.com.morador.utils;

import br.com.morador.domain.enuns.EnumAndar;
import br.com.morador.domain.enuns.EnumBloco;
import org.springframework.stereotype.Component;

@Component
public class FormatadorDadosApartamento {
    public EnumAndar andar(EnumAndar andar) {
        if (andar instanceof EnumAndar) {
            return andar;
        }
        return EnumAndar.ANDAR_IN;
    }

    public EnumBloco bloco(EnumBloco bloco) {
        if (bloco instanceof EnumBloco) {
            return bloco;
        }
        return EnumBloco.BLOC_IN;
    }

    public Integer numero(Integer numero) {
        if (numero instanceof Integer) {
            return numero;
        }
        return 0;
    }
}
