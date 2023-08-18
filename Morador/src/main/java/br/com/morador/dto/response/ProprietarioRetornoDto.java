package br.com.morador.dto.response;

import br.com.morador.domain.enuns.EnumSexo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProprietarioRetornoDto {
    private String uuidProprietario;
    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String dddPais;
    private String ddd;
    private String telefone;
    private EnumSexo sexo;
    private List<ApartamentosRetornoDto> apartamento = new ArrayList<>();

    public ProprietarioRetornoDto(ProprietarioRetornoDto dto) {
        this.uuidProprietario = dto.getUuidProprietario();
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
        this.rg = dto.getRg();
        this.dataNascimento = dto.getDataNascimento();
        this.dddPais = dto.getDddPais();
        this.ddd = dto.getDdd();
        this.telefone = dto.getTelefone();
        this.sexo = dto.getSexo();
        this.apartamento = dto.getApartamento();
    }
}