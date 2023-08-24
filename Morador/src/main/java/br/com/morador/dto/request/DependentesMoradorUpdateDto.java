package br.com.morador.dto.request;

import br.com.morador.domain.enuns.EnumSexo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class DependentesMoradorUpdateDto {
    private String uuidDependenteMorador;
    private String nome;
    @CPF
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String dddPais;
    private String ddd;
    private String telefone;
    private EnumSexo sexo;
}
