package br.com.funcionario.resource;

import br.com.funcionario.dto.AtualizarDependentesDto;
import br.com.funcionario.dto.DependenteDeletadoDto;
import br.com.funcionario.dto.DependentesAtualizarDto;
import br.com.funcionario.dto.DependentesDto;
import br.com.funcionario.service.DependenteService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/dependente")
public class DependenteResource {
    @Autowired
    private DependenteService dependenteService;

    @GetMapping("/{id}")
    public ResponseEntity<List<DependentesDto>> listarDepente(@PathVariable @NonNull Long id) {
        List<DependentesDto> dependentesDto = dependenteService.listarDepenteId(id);
        return ResponseEntity.ok(dependentesDto);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<AtualizarDependentesDto> atualizarDependente(@PathVariable @NonNull String uuid, @RequestBody @Valid DependentesAtualizarDto dependentesDto) {
        AtualizarDependentesDto dto = dependenteService.atualizarDepdente(uuid, dependentesDto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<AtualizarDependentesDto> cadastrarDependente(@PathVariable @NonNull Long id, @RequestBody @Valid DependentesDto dto, UriComponentsBuilder uriBuild) {
        AtualizarDependentesDto retorno = dependenteService.salvaDependente(id, dto);
        URI uri = uriBuild.path("/dependente/{id}").buildAndExpand(retorno.getUuidIdentificador()).toUri();
        return ResponseEntity.created(uri).body(retorno);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<DependenteDeletadoDto> deletarDependente(@PathVariable @NonNull String uuid){
        DependenteDeletadoDto dependente = dependenteService.deletarDependte(uuid);
        return ResponseEntity.ok(dependente);
    }
}
