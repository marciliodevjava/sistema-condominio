package br.com.gerador.dto;

import br.com.gerador.domain.enuns.EnumAtivo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class MatriculaFuncionarioDto {
    private Integer numeroFuncionario;
    private Integer idFuncionario;
    private EnumAtivo ativo;
}
