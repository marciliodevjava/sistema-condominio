package br.com.funcionario.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumeroDto {

    private Long id;
    private Long numeroFuncionario;
    private Long idFuncionario;
    private String ativo;
}
