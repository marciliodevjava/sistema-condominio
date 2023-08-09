package br.com.funcionario.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {
    @NotNull(message = "Campo cep inválido.")
    private String cep;
    @NotNull(message = "Campo logradouro inválido.")
    private String logradouro;
    @NotNull(message = "Campo numero inválido.")
    private String numero;
    @NotNull(message = "Campo bairro inválido.")
    private String bairro;
    @NotNull(message = "Campo cidade inválido.")
    private String cidade;
    @NotNull(message = "Campo uf inválido.")
    private String uf;
    private String pais;
}
