package br.com.funcionario.mapper;

import br.com.funcionario.dto.EnderecoDto;
import br.com.funcionario.model.Endereco;
import br.com.funcionario.utils.FormatadorDeDados;
import br.com.funcionario.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EnderecoMapper {
    @Autowired
    private FormatadorDeDados formatadorDeDados;
    @Autowired
    private GeradorUuid geradorUuid;

    public Endereco montarEndereco(EnderecoDto enderecoDto) {

        Endereco endereco = new Endereco();

        if(Objects.nonNull(enderecoDto)){

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
}
