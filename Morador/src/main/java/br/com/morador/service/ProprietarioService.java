package br.com.morador.service;

import br.com.morador.domain.Proprietario;
import br.com.morador.dto.request.ProprietarioDto;
import br.com.morador.dto.response.ProprietarioRetornoDto;
import br.com.morador.manager.ApartamentosManager;
import br.com.morador.manager.ProprietarioManager;
import br.com.morador.mapper.ProprietarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProprietarioService {
    @Autowired
    private ProprietarioMapper proprietarioMapper;
    @Autowired
    private ProprietarioManager proprietarioManager;
    @Autowired
    private ApartamentosManager apartamentosManager;

    public ProprietarioRetornoDto salvaProprietario(ProprietarioDto dto) {
        if (Objects.nonNull(dto)) {
            Proprietario proprietario = proprietarioMapper.mapearProprietario(dto);
            if (proprietario != null) {
                proprietario = proprietarioManager.salvarProprietario(proprietario);
                return new ProprietarioRetornoDto(proprietarioMapper.mapeiaProprietarioRetornoDto(proprietario));
            }
        }
        return null;
    }

    public ProprietarioRetornoDto salvaProprietarioCompleto(ProprietarioDto dto) {
        if (Objects.nonNull(dto)) {
            Proprietario proprietario = proprietarioMapper.mapearProprietario(dto);

            if (proprietario != null){
                proprietario = proprietarioManager.salvarProprietario(proprietario);

                ProprietarioRetornoDto proprietarioRetornoDto = new ProprietarioRetornoDto();
                proprietarioRetornoDto = proprietarioMapper.mapeiaProprietarioRetornoDto(proprietario);

                return proprietarioRetornoDto;
            }
        }
        return null;
    }
}