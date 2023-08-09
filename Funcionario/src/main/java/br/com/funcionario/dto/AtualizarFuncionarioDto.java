package br.com.funcionario.dto;

import br.com.funcionario.model.enuns.EstadoCivilEnum;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Getter
@Setter
public class AtualizarFuncionarioDto {
    private String nome;
    @CPF
    private String cpf;
    private String rg;
    private String dataNascimento;
    @Email
    private String email;
    private String ddd;
    private String telefone;
    private EstadoCivilEnum estadoCivil;
    private List<AtualizarDependentesDto> dependentes;
    private EnderecoDto endereco;

}

