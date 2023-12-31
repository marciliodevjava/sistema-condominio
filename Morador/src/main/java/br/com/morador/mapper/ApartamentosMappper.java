package br.com.morador.mapper;

import br.com.morador.domain.Apartamento;
import br.com.morador.domain.Proprietario;
import br.com.morador.dto.request.ApartamentosDto;
import br.com.morador.dto.request.ApartamentosUpdateDto;
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

    public List<Apartamento> mapearApartamento(Proprietario proprietario, List<ApartamentosDto> apartamento) {
        List<Apartamento> listApatamento = new ArrayList<>();
        if (Objects.nonNull(apartamento)) {
            Apartamento apt = new Apartamento();
            apartamento.forEach(a -> {
                apt.setProprietario(proprietario);
                apt.setUuidApartamento(geradorUuid.gerarUuid());
                apt.setAndar(formatadorDadosApartamento.andar(a.getAndar()));
                apt.setBloco(formatadorDadosApartamento.bloco(a.getBloco()));
                apt.setNumero(formatadorDadosApartamento.numero(a.getNumero()));
                apt.setMorador(moradorResponsavelMapper.mapearMorador(apt, a.getMorador()));

                listApatamento.add(apt);
            });
            return listApatamento;
        }
        return null;
    }

    public List<ApartamentosRetornoDto> mapeiaApartamentoRetornoDto(List<Apartamento> apartamento) {
        List<ApartamentosRetornoDto> list = new ArrayList<>();
        if (Objects.nonNull(apartamento)) {
            apartamento.forEach(a -> {
                ApartamentosRetornoDto apt = new ApartamentosRetornoDto();
                apt.setUuidApartamento(a.getUuidApartamento());
                apt.setNumero(a.getNumero());
                apt.setBloco(a.getBloco());
                apt.setAndar(a.getAndar());
                apt.setMorador(moradorResponsavelMapper.mapeiaMoradorResponsavelRetornoDto(a.getMorador()));
                list.add(apt);
            });
            return list;
        }
        return null;
    }

    public List<Apartamento> mepearUpdateApartamento(Proprietario proprietario, List<Apartamento> apartamento, List<ApartamentosUpdateDto> apartamentoDto) {
        if (Objects.nonNull(apartamento) && Objects.nonNull(apartamentoDto)) {
            apartamento.forEach(pro -> {
                apartamentoDto.forEach(apt -> {
                    if (pro.getUuidApartamento().equals(apt.getUuidApartamento())) {
                        pro.setNumero(!apt.equals(null) && !apt.toString().isEmpty() ? formatadorDadosApartamento.numero(apt.getNumero()) : pro.getNumero());
                        pro.setAndar(!apt.getAndar().equals(null) && !apt.getAndar().toString().isEmpty() ? formatadorDadosApartamento.andar(apt.getAndar()) : pro.getAndar());
                        pro.setBloco(!apt.getBloco().equals(null) && !apt.getBloco().toString().isEmpty() ? formatadorDadosApartamento.bloco(apt.getBloco()) : pro.getBloco());
                        pro.setMorador(!apt.getMorador().equals(null) ? moradorResponsavelMapper.mapearMoradorUpdate(pro, pro.getMorador(), apt.getMorador()) : pro.getMorador());
                        pro.setProprietario(proprietario);
                    }
                });
            });
            return apartamento;
        }
        return apartamento;
    }
}
