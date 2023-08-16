package br.com.morador.dto;

import br.com.morador.domain.Apartamentos;
import br.com.morador.domain.enuns.EnumSexo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProprietarioDto {
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String dddPais;
    private String ddd;
    private String telefone;
    private EnumSexo sexo;
    private List<Apartamentos> apartamento = new ArrayList<>();
}
