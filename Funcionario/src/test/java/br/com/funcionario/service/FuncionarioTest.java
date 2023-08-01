package br.com.funcionario.service;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.FuncionarioRetornoDto;
import br.com.funcionario.model.enuns.EstadoCivilEnum;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class FuncionarioTest {

    private final String NOME_FUNCIONARIO = "Kauê Sebastião Kevin Costaa";
    private final String CPF_FUNCIONARIO = "60829752196";
    private final String RG_FUNCIONARIO = "41.998.033-7";
    private final String EMAIL_FUNCIONARIO = "kaue.sebastiao.costa@foxtech.com.br";
    private final String DDD_FUNCIONARIO = "61";
    private final String TELEFONE_FUNCIONARIO = "986235689";

    @Autowired
    private FuncionarioService funcionarioService;

    @Test
    void criarFuncionarioRest() {
        FuncionarioRetornoDto funcionarioRetornoDto = new FuncionarioRetornoDto();
        FuncionarioDto funcionarioDto = this.criarFuncionarioDto();
        funcionarioRetornoDto = funcionarioService.salvarFuncionario(funcionarioDto);

        Assertions.assertEquals(funcionarioRetornoDto.getCpf(), CPF_FUNCIONARIO);
    }

    private FuncionarioDto criarFuncionarioDto() {
        FuncionarioDto funcionario = new FuncionarioDto();
        funcionario.setNome(NOME_FUNCIONARIO);
        funcionario.setCpf(CPF_FUNCIONARIO);
        funcionario.setRg(RG_FUNCIONARIO);
        funcionario.setEmail(EMAIL_FUNCIONARIO);
        funcionario.setDdd(DDD_FUNCIONARIO);
        funcionario.setTelefone(TELEFONE_FUNCIONARIO);
        funcionario.setEstadoCivil(EstadoCivilEnum.SOLTEIRO);

        return  funcionario;
    }
}
