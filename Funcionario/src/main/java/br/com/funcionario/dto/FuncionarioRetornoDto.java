package br.com.funcionario.dto;

import br.com.funcionario.model.enuns.EstadoCivilEnum;
import br.com.funcionario.model.enuns.EstadoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FuncionarioRetornoDto {

    private Long id;

    private String uuidIdentificador;
    private Integer numeroFuncionario;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private String ddd;
    private String telefone;
    private EstadoEnum situacao;
    private EstadoCivilEnum estadoCivil;
    private List<DependentesDto> dependentes;
    private EnderecoDto endereco;
}

