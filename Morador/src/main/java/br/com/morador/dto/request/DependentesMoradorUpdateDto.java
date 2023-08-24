package br.com.morador.dto.request;

import br.com.morador.domain.enuns.EnumSexo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
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
