package br.com.funcionario.dto;

import br.com.funcionario.model.enuns.GrauParentescoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AtualizarDependentesDto {
    private GrauParentescoEnum grauParentesco;
    private String uuidIdentificador;
    private String nome;
    private String dataNascimento;
    @CPF
    private String cpf;
    private String rg;
    private String ddd;
    private String telefone;
}
