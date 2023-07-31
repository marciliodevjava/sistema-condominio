package br.com.gerador.service;

import br.com.gerador.dto.MatriculaFuncionarioDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MatriculaFuncionarioServiceTest {

    @Autowired
    private MatriculaFuncionarioService funcionarioService;

    @Test
    void cadastroMatricula(){
        Long id = 1L;
        MatriculaFuncionarioDto matricula = funcionarioService.criarMatriculaFuncionarioService(id);

        Assertions.assertEquals(1L, Long.parseLong(String.valueOf(matricula.getIdFuncionario())));
    }
}
