package br.com.morador.resource;

import br.com.morador.dto.request.ProprietarioDto;
import br.com.morador.dto.response.ProprietarioRetornoDto;
import br.com.morador.service.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioResource {
    @Autowired
    private ProprietarioService proprietarioService;


    @PostMapping("/salvar-proprietario")
    public ResponseEntity<ProprietarioRetornoDto> salvar(@RequestBody ProprietarioDto dto, UriComponentsBuilder uriBuild) {
        ProprietarioRetornoDto retorno = proprietarioService.salvaProprietario(dto);
        URI uri = uriBuild.path("/buscar/{uuid}").buildAndExpand(retorno.getUuidProprietario()).toUri();
        return ResponseEntity.created(uri).body(retorno);
    }

    @PostMapping("/salvar-proprietario-completo")
    public ResponseEntity<ProprietarioRetornoDto> salvarCompleto(@RequestBody ProprietarioDto dto, UriComponentsBuilder uriBuild) {
        ProprietarioRetornoDto retorno = proprietarioService.salvaProprietarioCompleto(dto);
        URI uri = uriBuild.path("/buscar/{uuid}").buildAndExpand(retorno.getUuidProprietario()).toUri();
        return ResponseEntity.created(uri).body(retorno);
    }
}
