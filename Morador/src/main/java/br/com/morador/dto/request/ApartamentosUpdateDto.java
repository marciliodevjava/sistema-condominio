package br.com.morador.dto.request;

import br.com.morador.domain.enuns.EnumAndar;
import br.com.morador.domain.enuns.EnumBloco;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartamentosUpdateDto {
    private String uuidApartamento;
    private Integer numero;
    private EnumBloco bloco;
    private EnumAndar andar;
    private MoradorResponsavelUpdateDto morador;
}
