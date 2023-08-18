package br.com.morador.dto;

import br.com.morador.domain.enuns.EnumSexo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProprietarioDto {
    @NotNull(message = "nome invalido")
    private String nome;
    @NotNull(message = "nome invalido")
    private String cpf;
    @NotNull(message = "nome invalido")
    private String rg;
    @NotNull(message = "nome invalido")
    private String dataNascimento;
    @NotNull(message = "nome invalido")
    private String dddPais;
    @NotNull(message = "nome invalido")
    private String ddd;
    @NotNull(message = "nome invalido")
    private String telefone;
    @NotNull(message = "nome invalido")
    private EnumSexo sexo;
    @NotNull(message = "apartamento invalido")
    private List<ApartamentosDto> apartamento = new ArrayList<>();
}
