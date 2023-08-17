package br.com.morador.service;

import br.com.morador.domain.Apartamentos;
import br.com.morador.domain.MoradorResponsavel;
import br.com.morador.domain.Proprietario;
import br.com.morador.domain.Vagas;
import br.com.morador.dto.*;
import br.com.morador.mapper.ProprietarioMapper;
import br.com.morador.repository.ProprietarioRepository;
import br.com.morador.utils.FormatadorDadosMorador;
import br.com.morador.utils.FormatadorDadosProprietario;
import br.com.morador.utils.FormatadorDadosVagas;
import br.com.morador.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

}