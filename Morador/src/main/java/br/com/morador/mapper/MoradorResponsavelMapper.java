package br.com.morador.mapper;

import br.com.morador.domain.Apartamentos;
import br.com.morador.domain.MoradorResponsavel;
import br.com.morador.domain.Vagas;
import br.com.morador.dto.MoradorResponsavelDto;
import br.com.morador.dto.VagasDto;
import br.com.morador.utils.FormatadorDadosMorador;
import br.com.morador.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class MoradorResponsavelMapper {
    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private FormatadorDadosMorador formatadorDadosMorador;
    @Autowired
    private DependentesMapper dependentesMapper;

    public MoradorResponsavel mapearMorador(Apartamentos apt, MoradorResponsavelDto morador) {
        MoradorResponsavel moradorResponsavel = new MoradorResponsavel();
        if (Objects.nonNull(morador)){
            moradorResponsavel.setUuidMorador(geradorUuid.gerarUuid());
            moradorResponsavel.setNome(formatadorDadosMorador.formatadorNome(morador.getNome()));
            moradorResponsavel.setCpf(formatadorDadosMorador.formatadorCpf(morador.getCpf()));
            moradorResponsavel.setRg(formatadorDadosMorador.formatadorRg(morador.getRg()));
            moradorResponsavel.setDataNascimento(formatadorDadosMorador.formatadorStringParaDate(morador.getDataNascimento()));
            moradorResponsavel.setDddPais(formatadorDadosMorador.formatadorDddPais(morador.getDddPais()));
            moradorResponsavel.setDdd(formatadorDadosMorador.formatadorDdd(morador.getDdd()));
            moradorResponsavel.setTelefone(formatadorDadosMorador.formatadorTelefone(morador.getTelefone()));
            moradorResponsavel.setDependentes(dependentesMapper.mapearDependentes(moradorResponsavel, morador.getDependentes()));
            moradorResponsavel.setApartamento(apt);
            return moradorResponsavel;
        }
        return null;
    }
}