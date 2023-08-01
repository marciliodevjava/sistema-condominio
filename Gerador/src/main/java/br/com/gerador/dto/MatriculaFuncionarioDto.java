package br.com.gerador.dto;

import br.com.gerador.domain.enuns.EnumAtivo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatriculaFuncionarioDto {
    private Long id;
    private Integer numeroFuncionario;
    private Integer idFuncionario;
    private EnumAtivo ativo;
}
