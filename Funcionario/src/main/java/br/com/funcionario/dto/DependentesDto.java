package br.com.funcionario.dto;

import br.com.funcionario.model.enuns.GrauParentescoEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class DependentesDto {
    @NotNull(message = "Campo grauParentescoEnum inválido.")
    private GrauParentescoEnum grauParentescoEnum;
    @NotNull(message = "Campo nome inválido.")
    private String nome;
    @NotNull(message = "Campo dataNascimento inválido.")
    private String dataNascimento;
    @NotNull(message = "Campo cpf inválido.")
    @CPF
    private String cpf;
    @NotNull(message = "Campo rg inválido.")
    private String rg;
    @NotNull(message = "Campo ddd inválido.")
    private String ddd;
    @NotNull(message = "Campo telefone inválido.")
    private String telefone;
}
