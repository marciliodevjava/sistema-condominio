package br.com.funcionario.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoUpdateDto {
    private String uuidIdentificador;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String pais;
}
