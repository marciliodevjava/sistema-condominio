package br.com.morador.dto.request;

import br.com.morador.domain.enuns.EnumSetorVaga;
import br.com.morador.domain.enuns.EnumTiposVaga;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VagasUpdateDto {
    private String uuidVagas;
    private String numero;
    private EnumSetorVaga setor;
    private EnumTiposVaga tipo;
}
