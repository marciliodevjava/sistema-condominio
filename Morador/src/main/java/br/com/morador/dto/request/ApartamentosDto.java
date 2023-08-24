package br.com.morador.dto.request;

import br.com.morador.domain.enuns.EnumAndar;
import br.com.morador.domain.enuns.EnumBloco;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartamentosDto {
    @NotNull(message = "numero invalido")
    private Integer numero;
    @NotNull(message = "bloco invalido")
    private EnumBloco bloco;
    @NotNull(message = "andar invalido")
    private EnumAndar andar;
    private MoradorResponsavelDto morador;
}
