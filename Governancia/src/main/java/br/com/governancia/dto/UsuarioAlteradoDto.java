package br.com.governancia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
public class UsuarioAlteradoDto {
    private String nome;
    private String login;
    private String situacao = "Usuario atualizado com sucesso.";
}
