package br.com.morador.dto.response;

import br.com.morador.domain.enuns.EnumAndar;
import br.com.morador.domain.enuns.EnumBloco;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartamentosRetornoDto {
    private String uuidApartamento;
    private Integer numero;
    private EnumBloco bloco;
    private EnumAndar andar;
    private MoradorResponsavelRetornoDto morador;
}
