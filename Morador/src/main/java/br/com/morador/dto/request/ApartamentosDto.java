package br.com.morador.dto.request;

import br.com.morador.domain.enuns.EnumAndar;
import br.com.morador.domain.enuns.EnumBloco;
import br.com.morador.dto.request.MoradorResponsavelDto;
import br.com.morador.dto.request.VagasDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ApartamentosDto {
    @NotNull(message = "numero invalido")
    private Integer numero;
    @NotNull(message = "bloco invalido")
    private EnumBloco bloco;
    @NotNull(message = "andar invalido")
    private EnumAndar andar;
    private MoradorResponsavelDto morador;
    private List<VagasDto> vagas = new ArrayList<>();
}
