package br.com.morador.service;

import br.com.morador.domain.Proprietario;
import br.com.morador.dto.ProprietarioDeletadoDto;
import br.com.morador.dto.request.ProprietarioDto;
import br.com.morador.dto.request.ProprietarioUpdateDto;
import br.com.morador.dto.response.ProprietarioRetornoDto;
import br.com.morador.exception.ErroBuscarProprietarioException;
import br.com.morador.exception.ErroDeletarProprietarioException;
import br.com.morador.exception.ErroUuidInvalidoException;
import br.com.morador.manager.ProprietarioManager;
import br.com.morador.mapper.ProprietarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProprietarioService {
    @Autowired
    private ProprietarioMapper proprietarioMapper;
    @Autowired
    private ProprietarioManager proprietarioManager;

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

            if (proprietario != null) {
                proprietario = proprietarioManager.salvarProprietario(proprietario);

                ProprietarioRetornoDto proprietarioRetornoDto;
                proprietarioRetornoDto = proprietarioMapper.mapeiaProprietarioRetornoDto(proprietario);

                return proprietarioRetornoDto;
            }
        }
        return null;
    }

    public ProprietarioRetornoDto buscarProponente(String uuid) {
        Optional<Proprietario> proprietario = proprietarioManager.buscarProprietario(uuid);
        if (proprietario.isEmpty()){
            throw new ErroBuscarProprietarioException();
        }
        Proprietario dtoProprietario = proprietario.get();
        ProprietarioRetornoDto dto = proprietarioMapper.mapeiaProprietarioRetornoDto(dtoProprietario);

        return dto;
    }

    public ProprietarioRetornoDto atualizarProprietario(String uuid, ProprietarioUpdateDto proprietarioDto) {
        Proprietario pro = new Proprietario();
        if (Objects.nonNull(uuid)) {
            Optional<Proprietario> proprietario = proprietarioManager.buscarProprietario(uuid);
            pro = proprietarioMapper.atualizarProprietario(proprietario, proprietarioDto);
            pro = proprietarioManager.salvarProprietario(pro);
            ProprietarioRetornoDto dto = new ProprietarioRetornoDto();
            dto = proprietarioMapper.mapeiaProprietarioRetornoDto(pro);
            return dto;
        }
        throw new ErroUuidInvalidoException();
    }

    public ProprietarioDeletadoDto deletar(String uuid) {
        Optional<Proprietario> proprietario = proprietarioManager.buscarProprietario(uuid);
        if (proprietario.isEmpty()){
            throw new ErroDeletarProprietarioException();
        }
        if (Objects.nonNull(proprietario)){
            ProprietarioDeletadoDto pro = proprietarioManager.deletaProprietario(proprietario);
            return pro;
        }
        return null;
    }
}