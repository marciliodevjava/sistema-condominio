package br.com.funcionario.mapper;

import br.com.funcionario.dto.AtualizarEnderecoDto;
import br.com.funcionario.dto.EnderecoDto;
import br.com.funcionario.model.Endereco;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.utils.FormatadorDeDados;
import br.com.funcionario.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class EnderecoMapper {
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private GeradorUuid geradorUuid;

    public Endereco montarEndereco(EnderecoDto enderecoDto) {

        Endereco endereco = new Endereco();

        if (Objects.nonNull(enderecoDto)) {

            endereco.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
            endereco.setCep(formatadorDeDados.formatadorCepEndereco(enderecoDto.getCep()));
            endereco.setLogradouro(formatadorDeDados.formatadorLogradouroEndereco(enderecoDto.getLogradouro()));
            endereco.setNumero(formatadorDeDados.formatadorNumeroEndereco(enderecoDto.getNumero()));
            endereco.setBairro(formatadorDeDados.formatadorBairroEndereco(enderecoDto.getBairro()));
            endereco.setCidade(formatadorDeDados.formatadorCidadeEndereco(enderecoDto.getCidade()));
            endereco.setUf(formatadorDeDados.formatadorUfEndereco(enderecoDto.getUf()));
            endereco.setPais(formatadorDeDados.formatadorPaisEndereco(enderecoDto.getPais()));

            return endereco;
        }

        return null;
    }

    public Optional<Endereco> mapearDependenteAtualizar(Optional<Endereco> endereco, AtualizarEnderecoDto dto) {
        Endereco end = endereco.get();

        if (Objects.nonNull(dto)) {
            if (endereco.get().getUuidIdentificador().equals(dto.getUuidIdentificador())) {
                end.setCep(dto.getCep() != null ? formatadorDeDados.formatadorCepEndereco(dto.getCep()) : end.getCep());
                end.setLogradouro(dto.getLogradouro() != null ? formatadorDeDados.formatadorLogradouroEndereco(dto.getLogradouro()) : end.getLogradouro());
                end.setNumero(dto.getNumero() != null ? formatadorDeDados.formatadorNumeroEndereco(dto.getNumero()) : end.getNumero());
                end.setBairro(dto.getBairro() != null ? formatadorDeDados.formatadorBairroEndereco(dto.getBairro()) : end.getBairro());
                end.setUf(dto.getUf() != null ? formatadorDeDados.formatadorUfEndereco(dto.getUf()) : end.getUf());
                end.setPais(dto.getPais() != null ? formatadorDeDados.formatadorPaisEndereco(dto.getPais()) : end.getPais());
                return endereco;
            }
        }
        return null;
    }

    public Endereco mapearDependenteSalvar(Funcionario funcionario, EnderecoDto enderecoDto) {
        Endereco endereco = new Endereco();
        if (Objects.nonNull(enderecoDto)) {
            endereco.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
            endereco.setCep(formatadorDeDados.formatadorCepEndereco(enderecoDto.getCep()));
            endereco.setLogradouro(formatadorDeDados.formatadorLogradouroEndereco(enderecoDto.getLogradouro()));
            endereco.setNumero(formatadorDeDados.formatadorNumeroEndereco(enderecoDto.getNumero()));
            endereco.setBairro(formatadorDeDados.formatadorBairroEndereco(enderecoDto.getBairro()));
            endereco.setCidade(formatadorDeDados.formatadorCidadeEndereco(enderecoDto.getCidade()));
            endereco.setUf(formatadorDeDados.formatadorUfEndereco(enderecoDto.getUf()));
            endereco.setPais(formatadorDeDados.formatadorPaisEndereco(enderecoDto.getPais()));
            endereco.setFuncionario(funcionario);

            return endereco;
        }
        return null;
    }
}
