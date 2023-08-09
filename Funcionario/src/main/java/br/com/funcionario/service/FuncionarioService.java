package br.com.funcionario.service;

import br.com.funcionario.dto.FuncionarioDeletadoDto;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.FuncionarioRetornoDto;
import br.com.funcionario.dto.NumeroDto;
import br.com.funcionario.http.GeradorClients;
import br.com.funcionario.mapper.FuncionarioMapper;
import br.com.funcionario.model.Dependentes;
import br.com.funcionario.model.Endereco;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.repository.FuncionarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    @Autowired
    private GeradorClients geradorClients;
    @Autowired
    private ObjectMapper objectMapper;

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

        /**
         * CONTINUAÇÃO DO MÉTODO
         */

        return objectMapper.convertValue(funcionario, FuncionarioRetornoDto.class);
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
        if (Objects.nonNull(funcionarioRetornoDto)){
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

        return dto;
    }
}
