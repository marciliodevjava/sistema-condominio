package br.com.email.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {

    @NotBlank(message = "Campo idUsuario obrigatório.")
    private String idUsuario;
    @NotBlank(message = "Campo remetente obrigatório.")
    @Email
    private String remetente;
    @NotBlank(message = "Campo destinatario obrigatório.")
    @Email
    private String destinatario;
    @NotBlank(message = "Campo titulo obrigatório.")
    private String titulo;
    @NotBlank(message = "Campo texto obrigatório.")
    private String texto;
}
