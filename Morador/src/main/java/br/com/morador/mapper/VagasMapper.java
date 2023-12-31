package br.com.morador.mapper;

import br.com.morador.domain.MoradorResponsavel;
import br.com.morador.domain.Vagas;
import br.com.morador.dto.request.VagasDto;
import br.com.morador.dto.request.VagasUpdateDto;
import br.com.morador.dto.response.VagasRetornoDto;
import br.com.morador.utils.FormatadorDadosVagas;
import br.com.morador.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class VagasMapper {
    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private FormatadorDadosVagas formatadorDadosVagas;

    public List<Vagas> mapearVagas(MoradorResponsavel morador, List<VagasDto> vagas) {
        List<Vagas> listVagas = new ArrayList<>();
        if (Objects.nonNull(vagas)) {
            vagas.forEach(a -> {
                Vagas vag = new Vagas();
                vag.setUuidVagas(geradorUuid.gerarUuid());
                vag.setNumero(formatadorDadosVagas.numero(a.getNumero()));
                vag.setSetor(formatadorDadosVagas.setor(a.getSetor()));
                vag.setTipo(formatadorDadosVagas.tipo(a.getTipo()));
                vag.setMoradorResponsavel(morador);
                listVagas.add(vag);
            });
            return listVagas;
        }
        return null;
    }

    public List<VagasRetornoDto> mapeiaVagasRetornoDto(List<Vagas> vagas) {
        List<VagasRetornoDto> list = new ArrayList<>();
        if (Objects.nonNull(vagas)) {
            if (vagas.size() >= 0) {
                vagas.forEach(v -> {
                    VagasRetornoDto dto = new VagasRetornoDto(v);
                    list.add(dto);
                });
                return list;
            }
        }
        return null;
    }

    public List<Vagas> mapearVagasUpdate(MoradorResponsavel morador, List<Vagas> vagas, List<VagasUpdateDto> dto) {
        if (Objects.nonNull(vagas) && Objects.nonNull(dto)) {
            vagas.forEach(vap -> {
                dto.forEach(up -> {
                    if (vap.getUuidVagas().equals(up.getUuidVagas())) {
                        vap.setNumero(!up.getNumero().equals(null) && !up.getNumero().isEmpty() ? formatadorDadosVagas.numero(up.getNumero()) : vap.getNumero());
                        vap.setSetor(!up.getSetor().equals(null) && !up.getSetor().toString().isEmpty() ? formatadorDadosVagas.setor(up.getSetor()) : vap.getSetor());
                        vap.setTipo(!up.getTipo().equals(null) && !up.getTipo().toString().isEmpty() ? formatadorDadosVagas.tipo(up.getTipo()) : vap.getTipo());
                        vap.setMoradorResponsavel(morador);
                    }
                });
            });
            return vagas;
        }
        return vagas;
    }
}
