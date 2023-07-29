package br.com.gerador.service;

import br.com.gerador.domain.MatriculaFuncionario;
import br.com.gerador.dto.MatriculaFuncionarioDto;
import br.com.gerador.mapper.MatriculaFuncionarioMapper;
import br.com.gerador.repository.MatriculaFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MatriculaFuncionarioService {

    @Autowired
    private MatriculaFuncionarioMapper matriculaFuncionarioMapper;
    @Autowired
    private MatriculaFuncionarioRepository matriculaFuncionarioRepository;

    public MatriculaFuncionarioDto criarMatriculaFuncionarioService(Long id) {

        MatriculaFuncionario funcionario = new MatriculaFuncionario();

        funcionario = matriculaFuncionarioMapper.gerarFuncionario(id);
        funcionario = matriculaFuncionarioRepository.save(funcionario);


        return null;
    }
}
