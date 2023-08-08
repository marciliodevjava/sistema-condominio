package br.com.funcionario.service;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.FuncionarioRetornoDto;
import br.com.funcionario.model.enuns.EstadoCivilEnum;
import br.com.funcionario.utils.FormatadorDeDados;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
public class FuncionarioTest {

    private final String NOME_FUNCIONARIO = "Kauê Sebastião Kevin Costaa";
    private final String CPF_FUNCIONARIO = "60829752196";
    private final String RG_FUNCIONARIO = "41.998.033-7";
    private final String EMAIL_FUNCIONARIO = "kaue.sebastiao.costa@foxtech.com.br";
    private final String DDD_FUNCIONARIO = "61";
    private final String TELEFONE_FUNCIONARIO = "986235689";
    private final String DATA_FUNCIONARIO = "2023-08-03";

    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private FormatadorDeDados formatadorDeDados;

    @Test
    void criarFuncionarioRest() throws ParseException {
            FuncionarioRetornoDto funcionarioRetornoDto = new FuncionarioRetornoDto();
            FuncionarioDto funcionarioDto = this.criarFuncionarioDto();
            funcionarioRetornoDto = funcionarioService.salvarFuncionario(funcionarioDto);

            Assertions.assertEquals(funcionarioRetornoDto.getCpf(), funcionarioDto.getCpf());
    }

    private FuncionarioDto criarFuncionarioDto() throws ParseException {

        Faker faker = new Faker();
        FuncionarioDto funcionario = new FuncionarioDto();

        funcionario.setNome(faker.name().fullName());
        funcionario.setCpf(formatadorDeDados.formatadorCpf(faker.idNumber().valid()));
        funcionario.setRg(faker.idNumber().ssnValid());
        funcionario.setEmail(faker.internet().emailAddress());
        funcionario.setDdd(String.valueOf(faker.number().numberBetween(11, 99)));
        funcionario.setTelefone(faker.number().digits(9));
        funcionario.setEstadoCivil(EstadoCivilEnum.SOLTEIRO);
        funcionario.setDataNascimento(formatadorDeDados.formatadorDataDate(faker.date().birthday(18,65)));

        return  funcionario;
    }
}
