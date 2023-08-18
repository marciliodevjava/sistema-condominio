package br.com.morador.dto;

import br.com.morador.domain.enuns.EnumAndar;
import br.com.morador.domain.enuns.EnumBloco;
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
