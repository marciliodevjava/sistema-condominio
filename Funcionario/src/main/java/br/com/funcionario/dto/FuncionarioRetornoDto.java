package br.com.funcionario.dto;

import br.com.funcionario.model.Dependentes;
import br.com.funcionario.model.Endereco;
import br.com.funcionario.model.enuns.EstadoCivilEnum;
import br.com.funcionario.model.enuns.EstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioRetornoDto {

    private Long id;
    private String uuidIdentificador;
    private Integer numeroFuncionario;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String rg;
    private String email;
    private String ddd;
    private String telefone;
    private EstadoEnum situacao;
    private EstadoCivilEnum estadoCivil;
    private List<DependentesDto> dependentes = new ArrayList<DependentesDto>();
    private EnderecoDto endereco;

}

