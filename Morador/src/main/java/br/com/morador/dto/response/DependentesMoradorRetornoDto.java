package br.com.morador.dto.response;

import br.com.morador.domain.enuns.EnumSexo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DependentesMoradorRetornoDto {
    private String uuidDependenteMorador;
    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String dddPais;
    private String ddd;
    private String telefone;
    private EnumSexo sexo;
}
