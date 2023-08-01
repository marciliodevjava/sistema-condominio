package br.com.funcionario.mapper;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.NumeroDto;
import br.com.funcionario.http.GeradorClients;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.model.enuns.EstadoEnum;
import br.com.funcionario.utils.FormatadorDeDados;
import br.com.funcionario.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FuncionarioMapper {
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private GeradorUuid geradorUuid;
    public Funcionario mapear(FuncionarioDto dto) {
        Funcionario funcionario = new Funcionario();
        if (Objects.nonNull(dto.getNome())){
            funcionario.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
            funcionario.setNome(dto.getNome());
            funcionario.setCpf(dto.getCpf());
            funcionario.setRg(dto.getRg());
            funcionario.setEmail(dto.getEmail());
            funcionario.setDdd(dto.getDdd());
            funcionario.setTelefone(dto.getTelefone());
            funcionario.setSituacao(EstadoEnum.ATIVO);
            funcionario.setEstadoCivil(dto.getEstadoCivil());
        }
        return null;
    }
}
