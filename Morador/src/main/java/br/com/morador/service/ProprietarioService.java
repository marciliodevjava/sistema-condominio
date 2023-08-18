package br.com.morador.service;

import br.com.morador.domain.Proprietario;
import br.com.morador.dto.*;
import br.com.morador.mapper.ProprietarioMapper;
import br.com.morador.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProprietarioService {
    @Autowired
    private ProprietarioRepository proprietarioRepository;
    @Autowired
    private ProprietarioMapper proprietarioMapper;

    public ProprietarioRetornoDto salvaProprietario(ProprietarioDto dto) {
        if (Objects.nonNull(dto)) {
            Proprietario proprietario = proprietarioMapper.mapearProprietaSimples(dto);
        }
        return null;
    }

    public ProprietarioRetornoDto salvaProprietarioCompleto(ProprietarioDto dto) {
        if (Objects.nonNull(dto)) {
            Proprietario proprietario = proprietarioMapper.mapearProprietaSimples(dto);
        }
        return null;
    }
}