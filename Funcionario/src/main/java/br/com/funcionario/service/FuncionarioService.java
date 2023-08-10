package br.com.funcionario.service;

import br.com.funcionario.dto.*;
import br.com.funcionario.http.GeradorClients;
import br.com.funcionario.mapper.DependenteMapper;
import br.com.funcionario.mapper.EnderecoMapper;
import br.com.funcionario.mapper.FuncionarioMapper;
import br.com.funcionario.model.Dependentes;
import br.com.funcionario.model.Endereco;
import br.com.funcionario.model.Funcionario;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
        Endereco endereco = funcionario.getEndereco();

        funcionario = this.salvarFuncionarioRepositoru(funcionario);
        dependentesList = this.salvarDependenteRepository(funcionario, dependentesList);
        endereco = this.salvarEnderecoFuncionarioRepository(funcionario, endereco);

        FuncionarioRetornoDto dtoFuncionario = this.mapFuncionarioRetornoDto(funcionario);

        return dtoFuncionario;
    }

    private Endereco salvarEnderecoFuncionarioRepository(Funcionario funcionario, Endereco endereco) {
        if(Objects.nonNull(endereco)){
            endereco.setFuncionario(funcionario);
            endereco = enderecoRepository.save(endereco);
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

        return objectMapper.convertValue(funcionario, FuncionarioRetornoDto.class);
    }

    public FuncionarioDeletadoDto deletarUsuario(Long id) {
        Optional<Funcionario> funcionarioRetornoDto = funcionarioRepository.findById(id);
        if (Objects.nonNull(funcionarioRetornoDto)) {
            funcionarioRepository.deleteById(funcionarioRetornoDto.get().getId());

            return new FuncionarioDeletadoDto(id, "Funcionario Deletado com Sucesso!");
        }
        return new FuncionarioDeletadoDto(id, "Funcionario não deltado!");
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

    private EnderecoDto mapEnderecoDto(Endereco endereco) {
        EnderecoDto dto = new EnderecoDto();
        if (Objects.nonNull(endereco)){
            dto.setCep(endereco.getCep());
            dto.setUuidIdentificador(endereco.getUuidIdentificador());
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

    private List<Dependentes> salvarDependenteRepository(Funcionario funcionario, List<Dependentes> dependentesList) {
        if(Objects.nonNull(dependentesList)){
            dependentesList.forEach( list -> {
                list.setFuncionario(funcionario);
            });
            dependentesList = dependentesRepository.saveAll(dependentesList);
            return dependentesList;
        }
        return null;
    }

    private Funcionario salvarFuncionarioRepositoru(Funcionario funcionario) {
        if(Objects.nonNull(funcionario)){
            funcionario = funcionarioRepository.save(funcionario);
            if (funcionario != null){
                funcionario.setNumeroFuncionario(gerarNumeroFuncionario(funcionario.getId()));
                funcionarioRepository.save(funcionario);
            }
            return funcionario;
        }
        return null;
    }

    private List<DependentesDto> mapDependenteDto(List<Dependentes> dependentes) {
        List<DependentesDto> dto = new ArrayList<>();
        if (Objects.nonNull(dependentes)){
            DependentesDto dependenteList = new DependentesDto();
            dependentes.forEach( dep -> {
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
        dependentesList = dependenteMapper.mapearDependenteAtualizar(dependentesList, dto.getDependentes());
        Optional<Endereco> endereco = enderecoRepository.findByFuncionario(funcionario.get());
        endereco = enderecoMapper.mapearDependenteAtualizar(endereco, dto.getEndereco());

        return null;
    }
}
