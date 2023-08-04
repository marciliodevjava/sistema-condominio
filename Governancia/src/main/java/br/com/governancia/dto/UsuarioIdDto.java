package br.com.governancia.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class UsuarioIdDto {
    private Long id;
    private String nome;
    private String login;
    private String uuidIdentificador;
    private Date data;
    private LocalTime hora;
}
