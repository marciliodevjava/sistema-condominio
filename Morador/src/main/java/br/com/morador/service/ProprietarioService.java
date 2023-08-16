package br.com.morador.service;

import br.com.morador.dto.ProprietarioDto;
import br.com.morador.dto.ProprietarioRetornoDto;
import br.com.morador.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public ProprietarioRetornoDto salvaProprietario(ProprietarioDto dto) {
        return null;
    }
}
