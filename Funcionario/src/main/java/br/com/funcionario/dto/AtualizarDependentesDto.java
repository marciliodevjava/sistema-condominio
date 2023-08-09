package br.com.funcionario.dto;

import br.com.funcionario.model.enuns.GrauParentescoEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class AtualizarDependentesDto {
    private GrauParentescoEnum grauParentescoEnum;
    private String uuidIdentificador;
    private String nome;
    private String dataNascimento;
    @CPF
    private String cpf;
    private String rg;
    private String ddd;
    private String telefone;
}
