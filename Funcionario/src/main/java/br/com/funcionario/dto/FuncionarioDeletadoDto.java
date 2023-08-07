package br.com.funcionario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FuncionarioDeletadoDto {
    private Long id;
    private String mensagem;
}
