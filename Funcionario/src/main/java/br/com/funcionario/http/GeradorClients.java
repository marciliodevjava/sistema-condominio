package br.com.funcionario.http;

import br.com.funcionario.dto.NumeroDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("gerador-ms")
public interface GeradorClients {

    @RequestMapping(method = RequestMethod.POST, value = "/gerador/{id}")
    NumeroDto gerarFuncionario(@PathVariable  Long idFuncionario);
}
