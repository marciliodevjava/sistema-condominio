package br.com.morador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProprietarioDeletadoDto {

    private String mensagem;
    private LocalDate data;
    private Integer code;
    private String endpoint;
}
