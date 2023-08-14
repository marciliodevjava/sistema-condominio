package br.com.funcionario.service;

import br.com.funcionario.dto.EnderecoDto;
import br.com.funcionario.dto.EnderecoRetornoDto;
import br.com.funcionario.infra.exception.exception.EnderecoNaoExisteException;
import br.com.funcionario.infra.exception.exception.EnderecoNaoFoiSalvoException;
import br.com.funcionario.mapper.EnderecoMapper;
import br.com.funcionario.model.Endereco;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.repository.EnderecoRepository;
import br.com.funcionario.repository.FuncionarioRepository;
import br.com.funcionario.utils.FormatadorDeDados;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private EnderecoMapper enderecoMapper;

    public EnderecoRetornoDto getEndereco(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

        if (funcionario.isPresent()) {
            Optional<Endereco> endereco = enderecoRepository.findByFuncionario(funcionario.get());

            return objectMapper.convertValue(endereco, EnderecoRetornoDto.class);
        }

        throw new EnderecoNaoExisteException();
    }

    public EnderecoRetornoDto getEnderecoUuid(String uuid) {
        Optional<Endereco> endereco = enderecoRepository.findByUuidIdentificador(uuid);
        if (endereco.isPresent()) {
            return objectMapper.convertValue(endereco, EnderecoRetornoDto.class);
        }
        throw new EnderecoNaoExisteException();
    }

    public EnderecoRetornoDto cadastrarEndereco(Long id, EnderecoDto enderecoDto) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario != null){
            Endereco endereco = enderecoMapper.mapearDependenteSalvar(funcionario.get(), enderecoDto);
            endereco =enderecoRepository.save(endereco);

            return objectMapper.convertValue(endereco, EnderecoRetornoDto.class);
        }

        throw new EnderecoNaoFoiSalvoException();
    }
}
