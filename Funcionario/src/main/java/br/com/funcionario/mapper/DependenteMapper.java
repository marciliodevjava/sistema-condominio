package br.com.funcionario.mapper;

import br.com.funcionario.dto.AtualizarDependentesDto;
import br.com.funcionario.dto.DependentesDto;
import br.com.funcionario.model.Dependentes;
import br.com.funcionario.repository.DependentesRepository;
import br.com.funcionario.utils.FormatadorDeDados;
import br.com.funcionario.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class DependenteMapper {
    private final String DATA_INVALIDA = "S/D";
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private DependentesRepository dependentesRepository;

    public List<Dependentes> montarDependentes(List<DependentesDto> dependentesDto) {
        List<Dependentes> dependeteList = new ArrayList<>();

        if (Objects.nonNull(dependentesDto)) {
            Dependentes dependentesRetorno = new Dependentes();
            dependentesDto.forEach(dto -> {
                dependentesRetorno.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
                dependentesRetorno.setGrauParentesco(dto.getGrauParentescoEnum());
                dependentesRetorno.setNome(formatadorDeDados.formatadorNome(dto.getNome()));
                try {
                    dependentesRetorno.setDataNascimento(formatadorDeDados.formatadorDataString(dto.getDataNascimento()));
                } catch (ParseException e) {
                    throw new RuntimeException(DATA_INVALIDA);
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
        List<Dependentes> list = new ArrayList<>(dependentesList);

        if (Objects.nonNull(dependentes)) {
            list.forEach(a -> {
                dependentes.forEach(b -> {
                    if (a.getUuidIdentificador().equals(b.getUuidIdentificador())) {
                        a.setNome(formatadorDeDados.formatadorNome(b.getNome()));
                        try {
                            a.setDataNascimento(formatadorDeDados.formatadorDataString(String.valueOf(b.getDataNascimento())));
                        } catch (ParseException e) {
                            throw new RuntimeException(DATA_INVALIDA);
                        }
                        a.setCpf(formatadorDeDados.formatadorCpf(b.getCpf()));
                        a.setRg(formatadorDeDados.formatadorRg(b.getRg()));
                        a.setGrauParentesco(b.getGrauParentescoEnum());
                    }
                });
            });
            return list;
        }
        return null;
    }
}
