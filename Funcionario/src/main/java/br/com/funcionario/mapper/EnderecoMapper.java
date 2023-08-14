package br.com.funcionario.mapper;

import br.com.funcionario.dto.AtualizarEnderecoDto;
import br.com.funcionario.dto.EnderecoDto;
import br.com.funcionario.model.Endereco;
import br.com.funcionario.model.Funcionario;
import br.com.funcionario.utils.FormatadorDeDados;
import br.com.funcionario.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class EnderecoMapper {
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private GeradorUuid geradorUuid;

    public List<Endereco> montarEndereco(List<EnderecoDto> enderecoDto) {
        List<Endereco> list = new ArrayList<>();
        Endereco endereco = new Endereco();

        if (Objects.nonNull(enderecoDto)) {
            enderecoDto.forEach(end -> {
                endereco.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
                endereco.setCep(formatadorDeDados.formatadorCepEndereco(end.getCep()));
                endereco.setLogradouro(formatadorDeDados.formatadorLogradouroEndereco(end.getLogradouro()));
                endereco.setNumero(formatadorDeDados.formatadorNumeroEndereco(end.getNumero()));
                endereco.setBairro(formatadorDeDados.formatadorBairroEndereco(end.getBairro()));
                endereco.setCidade(formatadorDeDados.formatadorCidadeEndereco(end.getCidade()));
                endereco.setUf(formatadorDeDados.formatadorUfEndereco(end.getUf()));
                endereco.setPais(formatadorDeDados.formatadorPaisEndereco(end.getPais()));

                list.add(endereco);
            });

            return list;
        }

        return null;
    }

    public List<Endereco> mapearDependenteAtualizar(List<Endereco> endereco, List<AtualizarEnderecoDto> dto) {
        List<Endereco> list = new ArrayList<>(endereco);

        if(Objects.nonNull(dto)){
            list.forEach( end1 -> {
                dto.forEach( end2 -> {
                    if(end1.getUuidIdentificador().equals(end2.getUuidIdentificador())){
                        end1.setUuidIdentificador(end2.getUuidIdentificador());
                        end1.setLogradouro(formatadorDeDados.formatadorLogradouroEndereco(end2.getLogradouro()));
                        end1.setCep(formatadorDeDados.formatadorCepEndereco(end2.getCep()));
                        end1.setNumero(formatadorDeDados.formatadorNumeroEndereco(end2.getNumero()));
                        end1.setCidade(formatadorDeDados.formatadorCidadeEndereco(end2.getCidade()));
                        end1.setBairro(formatadorDeDados.formatadorBairroEndereco(end2.getBairro()));
                        end1.setUf(formatadorDeDados.formatadorUfEndereco(end2.getUf()));
                        end1.setPais(formatadorDeDados.formatadorPaisEndereco(end2.getPais()));
                    }
                });
            });
            return list;
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
