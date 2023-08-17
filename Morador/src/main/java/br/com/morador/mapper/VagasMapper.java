package br.com.morador.mapper;

import br.com.morador.domain.Apartamentos;
import br.com.morador.domain.Vagas;
import br.com.morador.dto.VagasDto;
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

    public List<Vagas> mapearVagas(Apartamentos apt, List<VagasDto> vagas) {
        List<Vagas> listVagas = new ArrayList<>();
        if (Objects.nonNull(vagas)){
            vagas.forEach( a -> {
                Vagas vag = new Vagas();
                vag.setApartamento(apt);
                vag.setUuidVagas(geradorUuid.gerarUuid());
                vag.setNumero(a.getNumero());
                vag.setSetor(a.getSetor());
                vag.setTipo(a.getTipo());
                listVagas.add(vag);
            });
            return listVagas;
        }
        return null;
    }
}
