package br.com.funcionario.service;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.FuncionarioRetornoDto;
import br.com.funcionario.mapper.FuncionarioMapper;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    public FuncionarioRetornoDto salvarFuncionario(FuncionarioDto dto) {
        Funcionario funcionario = funcionarioMapper.mapear(dto);
        return null;
    }
}
