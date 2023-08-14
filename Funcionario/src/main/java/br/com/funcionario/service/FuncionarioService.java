package br.com.funcionario.service;

import br.com.funcionario.dto.*;
import br.com.funcionario.http.GeradorClients;
import br.com.funcionario.infra.exception.exception.ErroDeletarFuncionarioException;
import br.com.funcionario.mapper.DependenteMapper;
import br.com.funcionario.mapper.EnderecoMapper;
import br.com.funcionario.mapper.FuncionarioMapper;
import br.com.funcionario.model.Dependentes;
import br.com.funcionario.model.Endereco;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.query.FuncionarioQuery;
import br.com.funcionario.repository.DependentesRepository;
import br.com.funcionario.repository.EnderecoRepository;
import br.com.funcionario.repository.FuncionarioRepository;
import br.com.funcionario.utils.FormatadorDeDados;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private DependentesRepository dependentesRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private FuncionarioMapper funcionarioMapper;
    @Autowired
    private DependenteMapper dependenteMapper;
    @Autowired
    private EnderecoMapper enderecoMapper;
    @Autowired
    private GeradorClients geradorClients;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private FuncionarioQuery funcionarioQuery;

    public FuncionarioRetornoDto salvarFuncionario(FuncionarioDto dto) throws ParseException {
        Funcionario funcionario = funcionarioMapper.mapear(dto);
        funcionario = funcionarioRepository.save(funcionario);
        funcionario.setNumeroFuncionario(gerarNumeroFuncionario(funcionario.getId()));
        funcionario = funcionarioRepository.save(funcionario);
        return objectMapper.convertValue(funcionario, FuncionarioRetornoDto.class);
    }

    public FuncionarioRetornoDto salvarFuncionarioCompleto(FuncionarioDto dto) throws ParseException {
        Funcionario funcionario = funcionarioMapper.mapearCompleto(dto);
        List<Dependentes> dependentesList = funcionario.getDependentes();
        List<Endereco> endereco = funcionario.getEndereco();

        funcionario = this.salvarFuncionarioRepositoru(funcionario);
        dependentesList = this.salvarDependenteRepository(funcionario, dependentesList);
        endereco = this.salvarEnderecoFuncionarioRepository(funcionario, endereco);

        FuncionarioRetornoDto dtoFuncionario = this.mapFuncionarioRetornoDto(funcionario);

        return dtoFuncionario;
    }

    private List<Dependentes> salvarDependenteRepository(Funcionario funcionario, List<Dependentes> dependentesList) {
        if (Objects.nonNull(dependentesList)) {
            dependentesList.forEach(dep -> {
                dep.setFuncionario(funcionario);
            });

            dependentesList = dependentesRepository.saveAll(dependentesList);
            return dependentesList;
        }
        return null;
    }

    private List<Endereco> salvarEnderecoFuncionarioRepository(Funcionario funcionario, List<Endereco> endereco) {
        if (Objects.nonNull(endereco)) {
            endereco.forEach(end -> {
                end.setFuncionario(funcionario);
            });
            endereco = enderecoRepository.saveAll(endereco);
            return endereco;
        }
        return null;
    }

    private Integer gerarNumeroFuncionario(Long id) {

        NumeroDto numero = geradorClients.gerarFuncionario(id);

        return Integer.parseInt(String.valueOf(numero.getNumeroFuncionario()));
    }

    public FuncionarioRetornoDto buscarFuncionarioId(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        List<Dependentes> dependentes = dependentesRepository.findByFuncionario(funcionario.get());
        List<Endereco> endereco = enderecoRepository.findByListFuncionario(funcionario.get().getId());

        FuncionarioRetornoDto funDto = objectMapper.convertValue(funcionario, FuncionarioRetornoDto.class);
        funDto.setDependentes(dependentes.stream().map(this::mapDependente).collect(Collectors.toList()));
        funDto.setEndereco(endereco.stream().map(this::mapEnderecoUpdateDto).collect(Collectors.toList()));

        return funDto;
    }

    private DependentesDto mapDependente(Dependentes dependentes) {
        DependentesDto dto = new DependentesDto();
        if (Objects.nonNull(dependentes)) {
            dto.setGrauParentescoEnum(dependentes.getGrauParentesco());
            dto.setUuidIdentificador(dependentes.getUuidIdentificador());
            dto.setNome(dependentes.getNome());
            dto.setCpf(dependentes.getCpf());
            dto.setRg(dependentes.getRg());
            try {
                dto.setDataNascimento(formatadorDeDados.formatadorDataDate(dependentes.getDataNascimento()));
            } catch (ParseException e) {
                throw new RuntimeException("S/D");
            }
            dto.setDdd(dependentes.getDdd());
            dto.setTelefone(dependentes.getTelefone());

            return dto;
        }
        return null;
    }

    public FuncionarioDeletadoDto deletarUsuario(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (!funcionario.isEmpty()) {
            funcionarioQuery.deletaFuncionario(id);

            return new FuncionarioDeletadoDto(id, "Funcionario deletado com SUCESSO!");
        }
        throw new ErroDeletarFuncionarioException("Não existe esse funcionario na base de dados.");
    }

    public Page<FuncionarioRetornoDto> obterTodos(Pageable paginacao) {
        Page<Funcionario> funcionario = funcionarioRepository.findAll(paginacao);
        List<FuncionarioRetornoDto> funcionarioDto = funcionario.getContent().stream()
                .map(this::mapFuncionarioRetornoDto)
                .collect(Collectors.toList());

        return new PageImpl<>(funcionarioDto, paginacao, funcionario.getTotalElements());
    }

    private FuncionarioRetornoDto mapFuncionarioRetornoDto(Funcionario funcionario) {
        FuncionarioRetornoDto dto = new FuncionarioRetornoDto();

        dto.setId(funcionario.getId());
        dto.setUuidIdentificador(funcionario.getUuidIdentificador());
        dto.setNumeroFuncionario(funcionario.getNumeroFuncionario());
        dto.setNome(funcionario.getNome());
        dto.setDataNascimento(funcionario.getDataNascimento());
        dto.setCpf(funcionario.getCpf());
        dto.setRg(funcionario.getRg());
        dto.setEmail(funcionario.getEmail());
        dto.setDdd(funcionario.getDdd());
        dto.setTelefone(funcionario.getTelefone());
        dto.setSituacao(funcionario.getSituacao());
        dto.setEstadoCivil(funcionario.getEstadoCivil());
        dto.setDependentes(this.mapDependenteDto(funcionario.getDependentes()));
        dto.setEndereco(this.mapEnderecoDto(funcionario.getEndereco()));

        return dto;
    }

    private List<EnderecoDto> mapEnderecoDto(List<Endereco> endereco) {
        List<EnderecoDto> list = new ArrayList<>();
        EnderecoDto dto = new EnderecoDto();
        if (Objects.nonNull(endereco)) {
            endereco.forEach(end -> {
                dto.setCep(end.getCep());
                dto.setUuidIdentificador(end.getUuidIdentificador());
                dto.setLogradouro(end.getLogradouro());
                dto.setNumero(end.getNumero());
                dto.setBairro(end.getBairro());
                dto.setCidade(end.getCidade());
                dto.setUf(end.getUf());
                dto.setPais(end.getPais());

                list.add(dto);
            });

            return list;
        }
        return null;
    }

    private List<Dependentes> salvarDependenteUpdateRepository(List<Dependentes> dependentesList) {
        if (Objects.nonNull(dependentesList)) {
            dependentesList = dependentesRepository.saveAll(dependentesList);
            return dependentesList;
        }
        return null;
    }

    private Funcionario salvarFuncionarioRepositoru(Funcionario funcionario) {
        if (Objects.nonNull(funcionario)) {
            funcionario = funcionarioRepository.save(funcionario);
            if (funcionario != null) {
                funcionario.setNumeroFuncionario(gerarNumeroFuncionario(funcionario.getId()));
                funcionarioRepository.save(funcionario);
            }
            return funcionario;
        }
        return null;
    }

    private List<DependentesDto> mapDependenteDto(List<Dependentes> dependentes) {
        List<DependentesDto> dto = new ArrayList<>();
        if (Objects.nonNull(dependentes)) {
            dependentes.forEach(dep -> {
                DependentesDto dependenteList = new DependentesDto();
                dependenteList.setUuidIdentificador(dep.getUuidIdentificador());
                dependenteList.setNome(dep.getNome());
                dependenteList.setCpf(dep.getCpf());
                dependenteList.setRg(dep.getRg());
                dependenteList.setDdd(dep.getDdd());
                dependenteList.setTelefone(dep.getTelefone());
                try {
                    dependenteList.setDataNascimento(formatadorDeDados.formatadorDataDate(dep.getDataNascimento()));
                } catch (ParseException e) {
                    throw new RuntimeException("Não ha data de nascimento");
                }
                dependenteList.setGrauParentescoEnum(dep.getGrauParentesco());

                dto.add(dependenteList);
            });
            return dto;
        }
        return null;
    }

    public FuncionarioRetornoDto atualizarFuncionario(Long id, AtualizarFuncionarioDto dto) throws ParseException {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        funcionario = funcionarioMapper.mapearFuncionarioAtualizar(funcionario, dto);
        List<Dependentes> dependentesList = dependentesRepository.findByFuncionario(funcionario.get());
        if (Objects.nonNull(dependentesList)) {
            dependentesList = dependenteMapper.mapearDependenteAtualizar(dependentesList, dto.getDependentes());
        }
        List<Endereco> endereco = enderecoRepository.findByFuncionario(funcionario.get());
        if (Objects.nonNull(endereco)) {
            endereco = enderecoMapper.mapearDependenteAtualizar(endereco, dto.getEndereco());
        }

        funcionario = this.salvarFuncionarioUpdateRepositoru(funcionario);
        dependentesList = this.salvarDependenteUpdateRepository(dependentesList);
        endereco = this.salvarEnderecoFuncionarioUpdateRepository(endereco);

        FuncionarioRetornoDto funcionarioRetornoDto = objectMapper.convertValue(funcionario, FuncionarioRetornoDto.class);
        List<DependentesDto> dependentesDtos = dependentesList.stream()
                .map(this::mapDependenteRetornoDto)
                .collect(Collectors.toList());
        List<EnderecoUpdateDto> enderecoDto = endereco.stream().map(this::mapEnderecoUpdateDto).collect(Collectors.toList());

        funcionarioRetornoDto.setDependentes(dependentesDtos);
        funcionarioRetornoDto.setEndereco(enderecoDto);

        return funcionarioRetornoDto;
    }

    private EnderecoUpdateDto mapEnderecoUpdateDto(Endereco end) {
        EnderecoUpdateDto dto = new EnderecoUpdateDto();
        Endereco endereco = end;
        if (Objects.nonNull(endereco)) {
            dto.setUuidIdentificador(endereco.getUuidIdentificador());
            dto.setCep(endereco.getCep());
            dto.setLogradouro(endereco.getLogradouro());
            dto.setNumero(endereco.getNumero());
            dto.setBairro(endereco.getBairro());
            dto.setCidade(endereco.getCidade());
            dto.setUf(endereco.getUf());
            dto.setPais(endereco.getPais());

            return dto;
        }
        return null;
    }

    private DependentesDto mapDependenteRetornoDto(Dependentes dependentes) {
        DependentesDto dto = new DependentesDto();
        if (Objects.nonNull(dependentes)) {
            dto.setGrauParentescoEnum(dependentes.getGrauParentesco());
            dto.setUuidIdentificador(dependentes.getUuidIdentificador());
            dto.setNome(dependentes.getNome());
            try {
                dto.setDataNascimento(formatadorDeDados.formatadorDataDate(dependentes.getDataNascimento()));
            } catch (ParseException e) {
                throw new RuntimeException("S/D");
            }
            dto.setCpf(dependentes.getCpf());
            dto.setRg(dependentes.getRg());
            dto.setDdd(dependentes.getDdd());
            dto.setTelefone(dependentes.getTelefone());
        }
        return dto;
    }

    private Optional<Funcionario> salvarFuncionarioUpdateRepositoru(Optional<Funcionario> funcionario) {
        if (Objects.nonNull(funcionario)) {
            Funcionario fun = funcionario.get();
            funcionario = Optional.of(funcionarioRepository.save(fun));
            if (funcionario != null) {
                funcionarioRepository.save(fun);
            }
            return funcionario;
        }
        return null;
    }

    private List<Endereco> salvarEnderecoFuncionarioUpdateRepository(List<Endereco> endereco) {
        if (Objects.nonNull(endereco)) {
            endereco = enderecoRepository.saveAll(endereco);
            return endereco;
        }
        return null;
    }
}
