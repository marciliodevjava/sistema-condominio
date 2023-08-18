package br.com.morador.dto;

import br.com.morador.domain.enuns.EnumSexo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoradorResponsavelDto {
    @NotNull(message = "nome invalido")
    private String nome;
    @NotNull(message = "cpf invalido")
    @CPF
    private String cpf;
    @NotNull(message = "rg invalido")
    private String rg;
    @NotNull(message = "dataNascimento invalido")
    private String dataNascimento;
    @NotNull(message = "dddPais invalido")
    private String dddPais;
    @NotNull(message = "ddd invalido")
    private String ddd;
    @NotNull(message = "telefone invalido")
    private String telefone;
    @NotNull(message = "sexo invalido")
    private EnumSexo sexo;
    private List<DependentesMoradorDto> dependentes = new ArrayList<>();
}
