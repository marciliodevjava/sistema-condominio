package br.com.morador.dto.request;

import br.com.morador.domain.enuns.EnumSetorVaga;
import br.com.morador.domain.enuns.EnumTiposVaga;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VagasDto {
    private String numero;
    private EnumSetorVaga setor;
    private EnumTiposVaga tipo;
}
