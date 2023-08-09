package br.com.funcionario.mapper;

import br.com.funcionario.dto.AtualizarDependentesDto;
import br.com.funcionario.dto.DependentesDto;
import br.com.funcionario.model.Dependentes;
import br.com.funcionario.utils.FormatadorDeDados;
import br.com.funcionario.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DependenteMapper {
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private GeradorUuid geradorUuid;

    public List<Dependentes> montarDependentes(List<DependentesDto> dependentesDto) {
        List<Dependentes> dependeteList = new ArrayList<>();

        if (Objects.nonNull(dependentesDto)){

            Dependentes dependentesRetorno = new Dependentes();

            dependentesDto.forEach( dto -> {
                dependentesRetorno.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
                dependentesRetorno.setGrauParentesco(dto.getGrauParentescoEnum());
                dependentesRetorno.setNome(formatadorDeDados.formatadorNome(dto.getNome()));
                try {
                    dependentesRetorno.setDataNascimento(formatadorDeDados.formatadorDataDate(dto.getDataNascimento()));
                } catch (ParseException e) {
                    throw new RuntimeException("Data de nascimento está vázia.");
                }
                dependentesRetorno.setCpf(formatadorDeDados.formatadorCpf(dto.getCpf()));
                dependentesRetorno.setRg(formatadorDeDados.formatadorRg(dto.getRg()));
                dependentesRetorno.setDdd(dto.getDdd());
                dependentesRetorno.setTelefone(formatadorDeDados.formatadorTelefone(dto.getTelefone()));

                dependeteList.add(dependentesRetorno);
            });

            return dependeteList;
        }

        return null;
    }

    public List<Dependentes> mapearDependenteAtualizar(List<Dependentes> dependentesList, List<AtualizarDependentesDto> dependentes) {
    }
}
