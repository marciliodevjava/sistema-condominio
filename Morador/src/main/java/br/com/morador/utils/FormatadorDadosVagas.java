package br.com.morador.utils;

import br.com.morador.domain.enuns.EnumSetorVaga;
import br.com.morador.domain.enuns.EnumTiposVaga;
import org.springframework.stereotype.Component;

@Component
public class FormatadorDadosVagas {
    public String numero(String numero) {
        numero = numero.replace(".", "");
        numero = numero.replace("-", "");
        return numero.trim();
    }

    public EnumSetorVaga setor(EnumSetorVaga setor) {
        if (setor instanceof  EnumSetorVaga){
            return setor;
        }
        return EnumSetorVaga.SETOR_INDEFINIDO;
    }

    public EnumTiposVaga tipo(EnumTiposVaga tipo) {
        if (tipo instanceof EnumTiposVaga){
            return tipo;
        }
        return EnumTiposVaga.S_CAR;
    }
}
