package br.com.funcionario.service;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.FuncionarioRetornoDto;
import br.com.funcionario.dto.NumeroDto;
import br.com.funcionario.http.GeradorClients;
import br.com.funcionario.mapper.FuncionarioMapper;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.repository.FuncionarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    @Autowired
    private GeradorClients geradorClients;
    @Autowired
    private ObjectMapper objectMapper;

    public FuncionarioRetornoDto salvarFuncionario(FuncionarioDto dto) {
        Funcionario funcionario = funcionarioMapper.mapear(dto);
        funcionario = funcionarioRepository.save(funcionario);
        funcionario.setNumeroFuncionario(gerarNumeroFuncionario(funcionario.getId()));
        funcionario = funcionarioRepository.save(funcionario);
        return objectMapper.convertValue(funcionario, FuncionarioRetornoDto.class);
    }

    private Integer gerarNumeroFuncionario(Long id) {

        NumeroDto numero = geradorClients.gerarFuncionario(id);

        return numero.getNumeroFuncionario();
    }
}
