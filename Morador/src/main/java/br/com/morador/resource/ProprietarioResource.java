package br.com.morador.resource;

import br.com.morador.dto.ProprietarioDeletadoDto;
import br.com.morador.dto.request.ProprietarioUpdateDto;
import br.com.morador.dto.request.ProprietarioDto;
import br.com.morador.dto.response.ProprietarioRetornoDto;
import br.com.morador.service.ProprietarioService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/buscar/{uuid}")
    public ResponseEntity<ProprietarioRetornoDto> getProprietário(@PathVariable String uuid) {
        ProprietarioRetornoDto dto = proprietarioService.buscarProponente(uuid);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/atualizar/{uuid}")
    public ResponseEntity<ProprietarioRetornoDto> atualizar(@PathVariable String uuid, @RequestBody ProprietarioUpdateDto proprietarioDto) {
        ProprietarioRetornoDto dto = proprietarioService.atualizarProprietario(uuid, proprietarioDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/deletar/{uuid}")
    public ResponseEntity<ProprietarioDeletadoDto> deletar(@PathVariable @NotNull String uuid){
        ProprietarioDeletadoDto deletado = proprietarioService.deletar(uuid);
        return ResponseEntity.ok(deletado);
    }
}
