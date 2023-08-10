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
import java.util.concurrent.atomic.AtomicReference;

@Component
public class DependenteMapper {
    private final String DATA_INVALIDA = "S/D";
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private GeradorUuid geradorUuid;

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
        List<Dependentes> add = new ArrayList<>();
        AtomicReference<Boolean> dados = new AtomicReference<>(false);

        if (Objects.nonNull(dependentes)) {
            list.forEach(a -> {
                dependentes.forEach(b -> {
                    if (formatadorDeDados.formatadorCpf(b.getCpf()).equals(a.getCpf())) {
                        a.setNome(formatadorDeDados.formatadorNome(b.getNome()));
                        try {
                            a.setDataNascimento(formatadorDeDados.formatadorDataString(String.valueOf(b.getDataNascimento())));
                        } catch (ParseException e) {
                            throw new RuntimeException(DATA_INVALIDA);
                        }
                        a.setCpf(formatadorDeDados.formatadorCpf(b.getCpf()));
                        a.setRg(formatadorDeDados.formatadorRg(b.getRg()));
                        a.setGrauParentesco(b.getGrauParentescoEnum());
                    } else {
                        Dependentes dep = new Dependentes();
                        dep.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
                        dep.setNome(formatadorDeDados.formatadorNome(b.getNome()));
                        try {
                            dep.setDataNascimento(formatadorDeDados.formatadorDataString(b.getDataNascimento()));
                        } catch (ParseException e) {
                            throw new RuntimeException(DATA_INVALIDA);
                        }
                        dep.setCpf(formatadorDeDados.formatadorCpf(b.getCpf()));
                        dep.setRg(formatadorDeDados.formatadorRg(b.getRg()));
                        dep.setDdd(b.getDdd());
                        dep.setTelefone(formatadorDeDados.formatadorTelefone(b.getTelefone()));
                        dep.setFuncionario(a.getFuncionario());

                        dados.set(true);
                        add.add(dep);
                    }
                });
            });
            if(dados.get()){
                list.addAll(add);
            }
            return list;
        }
        return null;
    }
}
