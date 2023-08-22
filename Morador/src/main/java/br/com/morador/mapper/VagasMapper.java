package br.com.morador.mapper;

import br.com.morador.domain.Apartamento;
import br.com.morador.domain.Vagas;
import br.com.morador.dto.request.VagasDto;
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

    public List<Vagas> mapearVagas(Apartamento apt, List<VagasDto> vagas) {
        List<Vagas> listVagas = new ArrayList<>();
        if (Objects.nonNull(vagas)) {
            vagas.forEach(a -> {
                Vagas vag = new Vagas();
                vag.setUuidVagas(geradorUuid.gerarUuid());
                vag.setNumero(formatadorDadosVagas.numero(a.getNumero()));
                vag.setSetor(formatadorDadosVagas.setor(a.getSetor()));
                vag.setTipo(formatadorDadosVagas.tipo(a.getTipo()));
                vag.setApartamento(apt);
                listVagas.add(vag);
            });
            return listVagas;
        }
        return null;
    }

    public List<VagasRetornoDto> mapeiaVagasRetornoDto(List<Vagas> vagas) {
        List<VagasRetornoDto> list = new ArrayList<>();
        if(Objects.nonNull(vagas)){
            vagas.forEach( v -> {
                VagasRetornoDto dto = new VagasRetornoDto(v);
                list.add(dto);
            });
            return list;
        }
        return null;
    }
}
