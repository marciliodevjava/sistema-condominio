package br.com.funcionario.dto;

import br.com.funcionario.model.enuns.EstadoCivilEnum;
import br.com.funcionario.model.enuns.EstadoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Getter
@Setter
public record FuncionarioDto(
        @NotNull(message = "Campo nome inválido.")
        String nome,
        @NotNull(message = "Campo cpf inválido.")
        @CPF
        String cpf,
        @NotNull(message = "Campo rg inválido.")
        String rg,
        @NotNull(message = "Campo e-mail inválido.")
        @Email
        String email,
        @NotNull(message = "Campo ddd inválido.")
        String ddd,
        @NotNull(message = "Campo telefone inválido.")
        String telefone,
        @NotBlank(message = "Campo situacao inválido.")
        EstadoEnum situacao,
        @NotBlank(message = "Campo estadoCivil inválio.")
        EstadoCivilEnum estadoCivil,
        List<DependentesDto> dependentes,
        EnderecoDto endereco) {

}
