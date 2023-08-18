package br.com.morador.mapper;

import br.com.morador.domain.Apartamentos;
import br.com.morador.domain.Proprietario;
import br.com.morador.dto.request.ApartamentosDto;
import br.com.morador.dto.response.ApartamentosRetornoDto;
import br.com.morador.utils.FormatadorDadosApartamento;
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
    @Autowired
    private FormatadorDadosApartamento formatadorDadosApartamento;

    public List<Apartamentos> mapearApartamento(Proprietario proprietario, List<ApartamentosDto> apartamento) {
        List<Apartamentos> listApatamento = new ArrayList<>();
        if (Objects.nonNull(apartamento)) {
            Apartamentos apt = new Apartamentos();
            apartamento.forEach(a -> {
                apt.setProprietario(proprietario);
                apt.setUuidApartamento(geradorUuid.gerarUuid());
                apt.setAndar(formatadorDadosApartamento.andar(a.getAndar()));
                apt.setBloco(formatadorDadosApartamento.bloco(a.getBloco()));
                apt.setNumero(formatadorDadosApartamento.numero(a.getNumero()));
                apt.setMorador(moradorResponsavelMapper.mapearMorador(apt, a.getMorador()));
                apt.setVagas(vagasMapper.mapearVagas(apt, a.getVagas()));
            });
        }
        return null;
    }

    public List<ApartamentosRetornoDto> mapeiaApartamentoRetornoDto(List<Apartamentos> apartamento) {
        List<ApartamentosRetornoDto> list = new ArrayList<>();
        if (Objects.nonNull(apartamento)){
            apartamento.forEach( a -> {
                ApartamentosRetornoDto apt = new ApartamentosRetornoDto();
                apt.setUuidApartamento(a.getUuidApartamento());
                apt.setNumero(a.getNumero());
                apt.setBloco(a.getBloco());
                apt.setAndar(a.getAndar());
                apt.setMorador(moradorResponsavelMapper.mapeiaMoradorResponsavelRetornoDto(a.getMorador()));
                apt.setVagas(vagasMapper.mapeiaVagasRetornoDto(a.getVagas()));
                list.add(apt);
            });
            return list;
        }
        return null;
    }
}
