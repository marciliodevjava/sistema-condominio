package br.com.morador.mapper;

import br.com.morador.domain.Apartamento;
import br.com.morador.domain.MoradorResponsavel;
import br.com.morador.dto.request.MoradorResponsavelDto;
import br.com.morador.dto.response.MoradorResponsavelRetornoDto;
import br.com.morador.utils.FormatadorDadosMorador;
import br.com.morador.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MoradorResponsavelMapper {
    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private FormatadorDadosMorador formatadorDadosMorador;
    @Autowired
    private DependentesMapper dependentesMapper;
    @Autowired
    private VagasMapper vagasMapper;

    public MoradorResponsavel mapearMorador(Apartamento apt, MoradorResponsavelDto morador) {
        MoradorResponsavel moradorResponsavel = new MoradorResponsavel();
        if (Objects.nonNull(morador)) {
            moradorResponsavel.setUuidMorador(geradorUuid.gerarUuid());
            moradorResponsavel.setNome(formatadorDadosMorador.formatadorNome(morador.getNome()));
            moradorResponsavel.setCpf(formatadorDadosMorador.formatadorCpf(morador.getCpf()));
            moradorResponsavel.setRg(formatadorDadosMorador.formatadorRg(morador.getRg()));
            moradorResponsavel.setDataNascimento(formatadorDadosMorador.formatadorStringParaDate(morador.getDataNascimento()));
            moradorResponsavel.setDddPais(formatadorDadosMorador.formatadorDddPais(morador.getDddPais()));
            moradorResponsavel.setDdd(formatadorDadosMorador.formatadorDdd(morador.getDdd()));
            moradorResponsavel.setTelefone(formatadorDadosMorador.formatadorTelefone(morador.getTelefone()));
            moradorResponsavel.setSexo(formatadorDadosMorador.formatadorSexo(morador.getSexo()));
            moradorResponsavel.setDependentes(dependentesMapper.mapearDependentes(moradorResponsavel, morador.getDependentes()));
            moradorResponsavel.setVagas(vagasMapper.mapearVagas(moradorResponsavel, morador.getVagas()));
            moradorResponsavel.setApartamento(apt);
            return moradorResponsavel;
        }
        return null;
    }

    public MoradorResponsavelRetornoDto mapeiaMoradorResponsavelRetornoDto(MoradorResponsavel morador) {
        MoradorResponsavelRetornoDto dto = new MoradorResponsavelRetornoDto();
        if (Objects.nonNull(morador)){
            dto.setUuidMorador(morador.getUuidMorador());
            dto.setNome(morador.getNome());
            dto.setCpf(morador.getCpf());
            dto.setRg(morador.getRg());
            dto.setDataNascimento(formatadorDadosMorador.formatadorDateParaString(morador.getDataNascimento()));
            dto.setDddPais(dto.getDddPais());
            dto.setDdd(dto.getDdd());
            dto.setTelefone(dto.getTelefone());
            dto.setDependentes(dependentesMapper.mapeiaDependentesRetornoDto(morador.getDependentes()));
            dto.setVagas(vagasMapper.mapeiaVagasRetornoDto(morador.getVagas()));
            return dto;
        }
        return null;
    }
}