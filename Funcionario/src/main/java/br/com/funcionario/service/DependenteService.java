package br.com.funcionario.service;

import br.com.funcionario.dto.AtualizarDependentesDto;
import br.com.funcionario.dto.DependentesDto;
import br.com.funcionario.infra.exception.exception.AtualizarDependenteNotFouldException;
import br.com.funcionario.infra.exception.exception.ListDependenteNotFouldException;
import br.com.funcionario.model.Dependentes;
import br.com.funcionario.repository.DependentesRepository;
import br.com.funcionario.utils.FormatadorDeDados;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DependenteService {
    @Autowired
    private DependentesRepository dependentesRepository;
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private ObjectMapper objectMapper;

    public List<DependentesDto> listarDepenteId(Long id) {

        List<Dependentes> listDepente = dependentesRepository.listDepentende(id);
        if (listDepente.isEmpty()) {
            throw new ListDependenteNotFouldException("Não existe dependente vinculados a esse id : " + id);
        }
        List<DependentesDto> listDto = listDepente.stream().map(this::mapDepentesDto).collect(Collectors.toList());

        return listDto;
    }

    public AtualizarDependentesDto atualizarDepdente(String uuid, DependentesDto dependentesDto) {
        Dependentes dependentes = dependentesRepository.findByUuidIdentificador(uuid);
        if (dependentes.equals(null)) {
            throw new AtualizarDependenteNotFouldException("Não foi possivel realizar a atualização de dependente.");
        }
        dependentes = dependentesRepository.save(dependentes = mapeamentoDepenteDto(dependentes, dependentesDto));
        return objectMapper.convertValue(dependentes, AtualizarDependentesDto.class);
    }

    private Dependentes mapeamentoDepenteDto(Dependentes dep, DependentesDto dto) {
        dep.setNome(dto.getNome() != null ? formatadorDeDados.formatadorNome(dto.getNome()) : dep.getNome());
        dep.setGrauParentesco(dto.getGrauParentescoEnum() != null ? dto.getGrauParentescoEnum() : dep.getGrauParentesco());
        try {
            dep.setDataNascimento(dto.getDataNascimento() != null ? formatadorDeDados.formatadorDataString(dto.getDataNascimento()) : dep.getDataNascimento());
        } catch (ParseException e) {
            throw new RuntimeException("S/D");
        }
        dep.setCpf(dto.getCpf() != null ? formatadorDeDados.formatadorCpf(dto.getCpf()) : dep.getCpf());
        dep.setRg(dto.getRg() != null ? formatadorDeDados.formatadorRg(dto.getRg()) : dep.getRg());
        dep.setDdd(dto.getDdd() != null ? dto.getDdd() : dep.getDdd());
        dep.setTelefone(dep.getTelefone() != null ? formatadorDeDados.formatadorTelefone(dto.getTelefone()) : dep.getTelefone());
        return dep;
    }

    private DependentesDto mapDepentesDto(Dependentes dependentes) {
        DependentesDto dto = new DependentesDto();

        if (dependentes != null) {

            dto.setGrauParentescoEnum(dependentes.getGrauParentesco());
            dto.setUuidIdentificador(dependentes.getUuidIdentificador());
            dto.setNome(dependentes.getNome());
            dto.setRg(dependentes.getRg());
            dto.setCpf(dependentes.getCpf());
            try {
                dto.setDataNascimento(String.valueOf(formatadorDeDados.formatadorDataDate(dependentes.getDataNascimento())));
            } catch (ParseException e) {
                throw new RuntimeException("S/D");
            }
            dto.setDdd(dependentes.getDdd());
            dto.setTelefone(dependentes.getTelefone());

            return dto;
        }
        return null;
    }
}
