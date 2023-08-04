package br.com.governancia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
    private String nome;
    private String nomeAtualizado;
    private String login;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String senha;
}
