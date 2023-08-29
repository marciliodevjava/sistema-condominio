package br.com.morador.resource;

import br.com.morador.dto.DependenteDeletadoDto;
import br.com.morador.dto.request.DependentesMoradorDto;
import br.com.morador.dto.response.DependentesMoradorRetornoDto;
import br.com.morador.service.DependentesMoradorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/dependente")
public class DependenteMoradorResource {
    @Autowired
    private DependentesMoradorService dependentesMoradorService;

    @PostMapping("/{uuid}")
    public ResponseEntity<DependentesMoradorRetornoDto> salvar(@PathVariable @NotNull String uuid,
                                                               @RequestBody @Valid DependentesMoradorDto dependentesMoradorDto,
                                                               UriComponentsBuilder builder) {
        DependentesMoradorRetornoDto dto = dependentesMoradorService.salvarDependente(uuid, dependentesMoradorDto);
        URI uri = builder.path("/buscar/{uuid}").buildAndExpand(dto.getUuidDependenteMorador()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/uuid")
    public ResponseEntity<DependenteDeletadoDto> deletar(@PathVariable @NotNull String uuid){
        DependenteDeletadoDto dto = dependentesMoradorService.deletar(uuid);
        return ResponseEntity.ok(dto);
    }
}
