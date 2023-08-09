package br.com.funcionario.mapper;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.model.enuns.EstadoEnum;
import br.com.funcionario.utils.FormatadorDeDados;
import br.com.funcionario.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Objects;

@Component
public class FuncionarioMapper {
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private DependenteMapper dependenteMapper;
    @Autowired
    private EnderecoMapper enderecoMapper;

    public Funcionario mapear(FuncionarioDto dto) throws ParseException {
        Funcionario funcionario = new Funcionario();
        if (Objects.nonNull(dto.getNome())){
            funcionario.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
            funcionario.setNome(formatadorDeDados.formatadorNome(dto.getNome()));
            funcionario.setCpf(formatadorDeDados.formatadorCpf(dto.getCpf()));
            funcionario.setRg(formatadorDeDados.formatadorRg(dto.getRg()));
            funcionario.setDataNascimento(formatadorDeDados.formatadorDataDate(dto.getDataNascimento()));
            funcionario.setEmail(formatadorDeDados.formatadorEmail(dto.getEmail()));
            funcionario.setDdd(formatadorDeDados.formatadorNome(dto.getDdd()));
            funcionario.setTelefone(formatadorDeDados.formatadorTelefone(dto.getTelefone()));
            funcionario.setSituacao(EstadoEnum.ATIVO);
            funcionario.setEstadoCivil(dto.getEstadoCivil());

            return funcionario;
        }
        return null;
    }

    public Funcionario mapearCompleto(FuncionarioDto dto) throws ParseException {
        Funcionario funcionario = new Funcionario();
        if(Objects.nonNull(dto.getNome())){
            funcionario.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
            funcionario.setNome(formatadorDeDados.formatadorNome(dto.getNome()));
            funcionario.setDataNascimento(formatadorDeDados.formatadorDataDate(dto.getDataNascimento()));
            funcionario.setCpf(formatadorDeDados.formatadorCpf(dto.getCpf()));
            funcionario.setRg(formatadorDeDados.formatadorRg(dto.getRg()));
            funcionario.setEmail(formatadorDeDados.formatadorEmail(dto.getEmail()));
            funcionario.setDdd(dto.getDdd());
            funcionario.setTelefone(formatadorDeDados.formatadorTelefone(dto.getTelefone()));
            funcionario.setSituacao(EstadoEnum.ATIVO);
            funcionario.setEstadoCivil(dto.getEstadoCivil());
            funcionario.setDependentes(dependenteMapper.montarDependentes(dto.getDependentes()));
            funcionario.setEndereco(enderecoMapper.montarEndereco(dto.getEndereco()));

            return funcionario;
        }
        return null;
    }
}
