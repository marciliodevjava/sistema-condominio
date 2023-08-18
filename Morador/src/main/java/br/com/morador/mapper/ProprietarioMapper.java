package br.com.morador.mapper;

import br.com.morador.domain.Proprietario;
import br.com.morador.dto.ProprietarioDto;
import br.com.morador.utils.FormatadorDadosProprietario;
import br.com.morador.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProprietarioMapper {
    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private FormatadorDadosProprietario formatadorDadosProprietario;
    @Autowired
    private ApartamentosMappper apartamentosMappper;

    public Proprietario mapearProprietaSimples(ProprietarioDto dto) {
        Proprietario proprietario = new Proprietario();
        if (Objects.nonNull(dto)) {
            proprietario.setUuidProprietario(geradorUuid.gerarUuid());
            proprietario.setNome(formatadorDadosProprietario.formatarNome(dto.getNome()));
            proprietario.setCpf(formatadorDadosProprietario.formatarCpf(dto.getCpf()));
            proprietario.setRg(formatadorDadosProprietario.formatarRg(dto.getRg()));
            proprietario.setDataNascimento(formatadorDadosProprietario.formatarStringParaDate(dto.getDataNascimento()));
            proprietario.setDddPais(formatadorDadosProprietario.formatarDddPais(dto.getDddPais()));
            proprietario.setDdd(formatadorDadosProprietario.formatarDdd(dto.getDdd()));
            proprietario.setTelefone(formatadorDadosProprietario.formatarTelefone(dto.getTelefone()));
            proprietario.setSexo(formatadorDadosProprietario.formatarSexo(dto.getSexo()));
            proprietario.setApartamento(apartamentosMappper.mapearApartamento(proprietario, dto.getApartamento()));
            return proprietario;
        }
        return null;
    }

}
