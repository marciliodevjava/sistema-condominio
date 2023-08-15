package br.com.funcionario.dto;

import br.com.funcionario.model.enuns.EstadoCivilEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
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
    private List<AtualizarEnderecoDto> endereco;

}

