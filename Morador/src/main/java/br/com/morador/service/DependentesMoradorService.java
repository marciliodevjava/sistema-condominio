package br.com.morador.service;

import br.com.morador.manager.DependentesManager;
import br.com.morador.mapper.DependentesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DependentesMoradorService {
    @Autowired
    private DependentesMapper dependentesMapper;
    @Autowired
    private DependentesManager dependentesManager;
}
