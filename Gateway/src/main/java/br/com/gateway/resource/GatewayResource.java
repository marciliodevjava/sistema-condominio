package br.com.gateway.resource;

import br.com.gateway.dto.RequisicaoPortaDto;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class GatewayResource {

    private final String resposta = "Requisição respondida pela instancia";
    @GetMapping("/port")
    public ResponseEntity<RequisicaoPortaDto> retornaPort(@Value("${local.server.port}") String port){

        RequisicaoPortaDto dados = new RequisicaoPortaDto(resposta, port, HttpStatus.SC_OK);
        return ResponseEntity.ok(dados);
    }
}
