package br.com.funcionario.resource;

import br.com.funcionario.dto.EnderecoDto;
import br.com.funcionario.dto.EnderecoRetornoDto;
import br.com.funcionario.dto.EntidadeDeletadaDto;
import br.com.funcionario.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoRetornoDto> getEndereco(@PathVariable @NonNull Long id) {
        EnderecoRetornoDto enderecoRetornoDto = enderecoService.getEndereco(id);
        return ResponseEntity.ok(enderecoRetornoDto);
    }

    @GetMapping("/buscar/{uuid}")
    public ResponseEntity<EnderecoRetornoDto> getEndereco(@PathVariable @NonNull String uuid) {
        EnderecoRetornoDto dto = enderecoService.getEnderecoUuid(uuid);
        return ResponseEntity.ok(dto);
    }


    @PostMapping("/{id}")
    public ResponseEntity<EnderecoRetornoDto> cadastrarEndereco(@PathVariable @Valid Long id, @RequestBody @Valid EnderecoDto enderecoDto, UriComponentsBuilder uriComponentsBuilder) {
        EnderecoRetornoDto dto = enderecoService.cadastrarEndereco(id, enderecoDto);
        URI uri = uriComponentsBuilder.path("/endereco/buscar/{uuid}").buildAndExpand(dto.getUuidIdentificador()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<EntidadeDeletadaDto> deletaEndereco(@PathVariable @NonNull String uuid){
        EntidadeDeletadaDto dto = enderecoService.deletaEndereco(uuid);
        return ResponseEntity.ok(dto);
    }
}
