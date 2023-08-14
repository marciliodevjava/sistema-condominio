package br.com.funcionario.service;

import br.com.funcionario.dto.AtualizarDependentesDto;
import br.com.funcionario.dto.DependenteDeletadoDto;
import br.com.funcionario.dto.DependentesAtualizarDto;
import br.com.funcionario.dto.DependentesDto;
import br.com.funcionario.infra.exception.exception.AtualizarDependenteNotFouldException;
import br.com.funcionario.infra.exception.exception.DependenteInformaoNaoExiste;
import br.com.funcionario.infra.exception.exception.FuncionarioNaoExisteException;
import br.com.funcionario.infra.exception.exception.ListDependenteNotFouldException;
import br.com.funcionario.model.Dependentes;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.repository.DependentesRepository;
import br.com.funcionario.repository.FuncionarioRepository;
import br.com.funcionario.utils.FormatadorDeDados;
import br.com.funcionario.utils.GeradorUuid;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DependenteService {
    @Autowired
    private DependentesRepository dependentesRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private GeradorUuid geradorUuid;

    public List<DependentesDto> listarDepenteId(Long id) {

        List<Dependentes> listDepente = dependentesRepository.listDepentende(id);
        if (listDepente.isEmpty()) {
            throw new ListDependenteNotFouldException("Não existe dependente vinculados a esse id : " + id);
        }
        List<DependentesDto> listDto = listDepente.stream().map(this::mapDepentesDto).collect(Collectors.toList());

        return listDto;
    }

    public AtualizarDependentesDto atualizarDepdente(String uuid, DependentesAtualizarDto dependentesDto) {
        Dependentes dependentes = dependentesRepository.findByUuidIdentificador(uuid);
        if (dependentes.equals(null)) {
            throw new AtualizarDependenteNotFouldException("Não foi possivel realizar a atualização de dependente.");
        }
        dependentes = dependentesRepository.save(dependentes = mapeamentoDepenteDto(dependentes, dependentesDto));
        return objectMapper.convertValue(dependentes, AtualizarDependentesDto.class);
    }

    private Dependentes mapeamentoDepenteDto(Dependentes dep, DependentesAtualizarDto dto) {
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

    public AtualizarDependentesDto salvaDependente(Long id, DependentesDto dto) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isEmpty()) {
            throw new FuncionarioNaoExisteException();
        }
        Dependentes dependentes = dependentesRepository.save(this.atualizarDependente(funcionario, dto));
        return objectMapper.convertValue(dependentes, AtualizarDependentesDto.class);
    }

    private Dependentes atualizarDependente(Optional<Funcionario> funcionario, DependentesDto dto) {
        Dependentes dependentes = new Dependentes();
        if (Objects.nonNull(dto)) {
            dependentes.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
            dependentes.setGrauParentesco(dto.getGrauParentescoEnum());
            dependentes.setNome(formatadorDeDados.formatadorNome(dto.getNome()));
            try {
                dependentes.setDataNascimento(formatadorDeDados.formatadorDataString(dto.getDataNascimento()));
            } catch (ParseException e) {
                throw new RuntimeException("S/D");
            }
            dependentes.setCpf(formatadorDeDados.formatadorCpf(dto.getCpf()));
            dependentes.setRg(formatadorDeDados.formatadorRg(dto.getRg()));
            dependentes.setDdd(dto.getDdd());
            dependentes.setTelefone(formatadorDeDados.formatadorTelefone(dto.getTelefone()));
            dependentes.setFuncionario(funcionario.get());

            return dependentes;
        }
        return null;
    }

    public DependenteDeletadoDto deletarDependte(String uuid) {
        Dependentes dependentes = dependentesRepository.findByUuidIdentificador(uuid);
        if (dependentes != null){
            dependentesRepository.delete(dependentes);
            return new DependenteDeletadoDto(dependentes.getId(), "Dependente deletado com Sucesso!");
        }

        throw new DependenteInformaoNaoExiste();
    }

    public AtualizarDependentesDto getDependente(String uuid) {
        Dependentes dependentes = dependentesRepository.findByUuidIdentificador(uuid);
        if(dependentes == null){
            throw new DependenteInformaoNaoExiste();
        }

        return objectMapper.convertValue(dependentes, AtualizarDependentesDto.class);
    }
}
