package br.com.funcionario.service;

import br.com.funcionario.dto.FuncionarioDeletadoDto;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.FuncionarioRetornoDto;
import br.com.funcionario.dto.NumeroDto;
import br.com.funcionario.http.GeradorClients;
import br.com.funcionario.mapper.FuncionarioMapper;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.repository.FuncionarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Objects;
import java.util.Optional;

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
}
