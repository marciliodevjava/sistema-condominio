package br.com.morador.dto;

import br.com.morador.domain.MoradorResponsavel;
import br.com.morador.domain.Proprietario;
import br.com.morador.domain.Vagas;
import br.com.morador.domain.enuns.EnumAndar;
import br.com.morador.domain.enuns.EnumBloco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
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
