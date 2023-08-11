package br.com.funcionario.resource;

import br.com.funcionario.dto.AtualizarDependentesDto;
import br.com.funcionario.dto.DependentesDto;
import br.com.funcionario.service.DependenteService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<AtualizarDependentesDto> atualizarDependente(@PathVariable @NonNull String uuid, @RequestBody @Valid DependentesDto dependentesDto) {
        AtualizarDependentesDto dto = dependenteService.atualizarDepdente(uuid, dependentesDto);
        return ResponseEntity.ok(dto);
    }
}
