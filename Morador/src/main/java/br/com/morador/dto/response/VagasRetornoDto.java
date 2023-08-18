package br.com.morador.dto.response;

import br.com.morador.domain.Vagas;
import br.com.morador.domain.enuns.EnumSetorVaga;
import br.com.morador.domain.enuns.EnumTiposVaga;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VagasRetornoDto {
    private String uuidVagas;
    private String numero;
    private EnumSetorVaga setor;
    private EnumTiposVaga tipo;

    public VagasRetornoDto(Vagas v) {
        this.uuidVagas = v.getUuidVagas();
        this.numero = v.getNumero();
        this.setor = v.getSetor();
        this.tipo = v.getTipo();
    }
}
