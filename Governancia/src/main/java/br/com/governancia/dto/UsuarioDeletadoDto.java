package br.com.governancia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDeletadoDto {
    private Long id;
    private String mensagem;
}
