package br.com.morador.mapper;

import br.com.morador.domain.Apartamentos;
import br.com.morador.domain.Proprietario;
import br.com.morador.dto.ApartamentosDto;
import br.com.morador.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ApartamentosMappper {
    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private MoradorResponsavelMapper moradorResponsavelMapper;
    @Autowired
    private VagasMapper vagasMapper;

    public List<Apartamentos> mapearApartamento(Proprietario proprietario, List<ApartamentosDto> apartamento) {
        List<Apartamentos> listApatamento = new ArrayList<>();
        if (Objects.nonNull(apartamento)) {
            Apartamentos apt = new Apartamentos();
            apartamento.forEach(a -> {
                apt.setProprietario(proprietario);
                apt.setUuidApartamento(geradorUuid.gerarUuid());
                apt.setAndar(a.getAndar());
                apt.setBloco(a.getBloco());
                apt.setNumero(a.getNumero());
                apt.setMorador(moradorResponsavelMapper.mapearMorador(apt, a.getMorador()));
                apt.setVagas(vagasMapper.mapearVagas(apt, a.getVagas()));
            });
        }
        return null;
    }
}
