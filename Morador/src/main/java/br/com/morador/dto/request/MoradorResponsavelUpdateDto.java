package br.com.morador.dto.request;

import br.com.morador.domain.enuns.EnumSexo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoradorResponsavelUpdateDto {
    private String uuidMorador;
    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String dddPais;
    private String ddd;
    private String telefone;
    private EnumSexo sexo;
    private List<DependentesMoradorUpdateDto> dependentes = new ArrayList<>();
    private List<VagasUpdateDto> vagas = new ArrayList<>();
}
