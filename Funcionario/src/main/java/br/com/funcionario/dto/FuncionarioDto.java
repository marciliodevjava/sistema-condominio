package br.com.funcionario.dto;

import br.com.funcionario.model.enuns.EstadoCivilEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Getter
@Setter
public class FuncionarioDto{
        @NotNull(message = "Campo nome inválido.")
        private String nome;
        @NotNull(message = "Campo cpf inválido.")
        @CPF
        private String cpf;
        @NotNull(message = "Campo rg inválido.")
        private String rg;
        @NotNull(message = "Campo dataNascimento inválido.")
        private String dataNascimento;
        @NotNull(message = "Campo e-mail inválido.")
        @Email
        private String email;
        @NotNull(message = "Campo ddd inválido.")
        private String ddd;
        @NotNull(message = "Campo telefone inválido.")
        private String telefone;
        @NotNull(message = "Campo estadoCivil inválio.")
        private EstadoCivilEnum estadoCivil;
        private List<DependentesDto> dependentes;
        private List<EnderecoDto> endereco;

}
