package br.com.funcionario.mapper;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.model.Funcionario;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FuncionarioMapper {
    public Funcionario mapear(FuncionarioDto dto) {
        Funcionario funcionario = new Funcionario();
        if (Objects.nonNull(dto.getNome())){
            funcionario.setNumeroFuncionario(1);
            funcionario.setNome(dto.getNome());
            funcionario.setCpf(dto.getCpf());
            funcionario.setRg(dto.getRg());
            funcionario.setEmail(dto.getEmail());
            funcionario.setDdd(dto.getDdd());
            funcionario.setTelefone(dto.getTelefone());
            funcionario.setSituacao(dto.getSituacao());
            funcionario.setEstadoCivil(dto.getEstadoCivil());
        }
        return null;
    }
}
