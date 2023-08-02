package br.com.gerador.service;

import br.com.gerador.domain.MatriculaFuncionario;
import br.com.gerador.dto.MatriculaFuncionarioAtualizarDto;
import br.com.gerador.dto.MatriculaFuncionarioDto;
import br.com.gerador.mapper.MatriculaFuncionarioMapper;
import br.com.gerador.repository.MatriculaFuncionarioRepository;
import br.com.gerador.utils.LoggerUltis;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatriculaFuncionarioService {

    @Autowired
    private MatriculaFuncionarioMapper matriculaFuncionarioMapper;
    @Autowired
    private MatriculaFuncionarioRepository matriculaFuncionarioRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private LoggerUltis logger;

    public MatriculaFuncionarioDto criarMatriculaFuncionarioService(Long id) {
        logger.logInfo("Iniciando método de criação de matricula do funcionario.");
        MatriculaFuncionario funcionario = new MatriculaFuncionario();

        funcionario = matriculaFuncionarioMapper.gerarFuncionario(id);
        funcionario = matriculaFuncionarioRepository.save(funcionario);
        logger.logInfo("Iniciando método para salvar funcionario ", funcionario);

        logger.logInfo("Finalizando método de criação de matricula do funcionario.");
        return objectMapper.convertValue(funcionario, MatriculaFuncionarioDto.class);
    }

    public MatriculaFuncionarioDto buscarFuncionarioPorId(Long id) {
        Optional<MatriculaFuncionario> matriculaFuncionario = matriculaFuncionarioRepository.findById(id);
        return objectMapper.convertValue(matriculaFuncionario, MatriculaFuncionarioDto.class);
    }

    public MatriculaFuncionarioDto atualizarMatricula(Long id, MatriculaFuncionarioAtualizarDto funcionarioAtualizarDto) {
        Optional<MatriculaFuncionario> atualizarFuncionario = matriculaFuncionarioRepository.findById(id);
        return objectMapper.convertValue(atualizarFuncionario, MatriculaFuncionarioDto.class);
    }
}
