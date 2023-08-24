package br.com.morador.mapper;

import br.com.morador.domain.Apartamento;
import br.com.morador.domain.MoradorResponsavel;
import br.com.morador.dto.request.MoradorResponsavelDto;
import br.com.morador.dto.request.MoradorResponsavelUpdateDto;
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
        if (Objects.nonNull(morador)) {
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

    public MoradorResponsavel mapearMoradorUpdate(Apartamento pro, MoradorResponsavel morador, MoradorResponsavelUpdateDto mru) {
        if (Objects.nonNull(morador) && Objects.nonNull(mru)) {
            morador.setNome(!mru.getNome().equals(null) && !mru.getNome().isEmpty() ? formatadorDadosMorador.formatadorNome(mru.getNome()) : morador.getNome());
            morador.setCpf(!mru.getCpf().equals(null) && !mru.getCpf().isEmpty() ? formatadorDadosMorador.formatadorCpf(mru.getCpf()) : morador.getCpf());
            morador.setRg(!mru.getRg().equals(null) && !mru.getRg().isEmpty() ? formatadorDadosMorador.formatadorRg(mru.getRg()) : morador.getCpf());
            morador.setDataNascimento(!mru.getDataNascimento().equals(null) && !mru.getDataNascimento().isEmpty() ? formatadorDadosMorador.formatadorStringParaDate(mru.getDataNascimento()) : morador.getDataNascimento());
            morador.setDddPais(!mru.getDddPais().equals(null) && !mru.getDddPais().isEmpty() ? formatadorDadosMorador.formatadorDddPais(mru.getDddPais()) : morador.getDddPais());
            morador.setDdd(!mru.getDdd().equals(null) && !mru.getDdd().isEmpty() ? formatadorDadosMorador.formatadorDdd(mru.getDdd()) : morador.getDdd());
            morador.setTelefone(!mru.getTelefone().equals(null) && !mru.getTelefone().isEmpty() ? formatadorDadosMorador.formatadorTelefone(mru.getTelefone()) : morador.getTelefone());
            morador.setDependentes(!mru.getDependentes().equals(null) ? dependentesMapper.mapearDependentesUpdate(morador, morador.getDependentes(), mru.getDependentes()) : morador.getDependentes());
            morador.setVagas(!mru.getVagas().equals(null) ? vagasMapper.mapearVagasUpdate(morador, morador.getVagas(), mru.getVagas()) : morador.getVagas());

            return morador;
        }
        return null;
    }
}