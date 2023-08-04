package br.com.governancia.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioListaDto {
    private Long id;
    private String nome;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeAtualizado;
    @JsonIgnore
    private String senha;
    private String login;
}
