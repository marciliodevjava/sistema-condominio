package br.com.gerador.service;

import br.com.gerador.domain.MatriculaFuncionario;
import br.com.gerador.dto.MatriculaFuncionarioDto;
import br.com.gerador.mapper.MatriculaFuncionarioMapper;
import br.com.gerador.repository.MatriculaFuncionarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class MatriculaFuncionarioService {

    @Autowired
    private MatriculaFuncionarioMapper matriculaFuncionarioMapper;
    @Autowired
    private MatriculaFuncionarioRepository matriculaFuncionarioRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public MatriculaFuncionarioDto criarMatriculaFuncionarioService(Long id) {

        MatriculaFuncionario funcionario = new MatriculaFuncionario();

        funcionario = matriculaFuncionarioMapper.gerarFuncionario(id);
        funcionario = matriculaFuncionarioRepository.save(funcionario);

        return objectMapper.convertValue(funcionario, MatriculaFuncionarioDto.class);
    }

    public MatriculaFuncionarioDto buscarFuncionarioPorId(Long id) {
        Optional<MatriculaFuncionario> matriculaFuncionario = matriculaFuncionarioRepository.findById(id);
        return objectMapper.convertValue(matriculaFuncionario, MatriculaFuncionarioDto.class);
    }
}
