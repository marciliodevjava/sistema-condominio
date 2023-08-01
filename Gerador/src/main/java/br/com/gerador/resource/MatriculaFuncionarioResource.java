package br.com.gerador.resource;

import br.com.gerador.dto.MatriculaFuncionarioDto;
import br.com.gerador.dto.MatriculaFuncionarioUtualizarDto;
import br.com.gerador.service.MatriculaFuncionarioService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/gerador")
public class MatriculaFuncionarioResource {

    @Autowired
    private MatriculaFuncionarioService funcionarioService;

    @PostMapping("/{id}")
    public ResponseEntity<MatriculaFuncionarioDto> gerarMatricula(@PathVariable @NotNull Long id, UriComponentsBuilder uri) {
        MatriculaFuncionarioDto matriculaFuncionario = funcionarioService.criarMatriculaFuncionarioService(id);
        URI retorno = uri.path("/gerador/{id}").buildAndExpand(matriculaFuncionario.getId()).toUri();
        return ResponseEntity.created(retorno).body(matriculaFuncionario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaFuncionarioDto> getMatricula(@PathVariable Long id) {
        MatriculaFuncionarioDto matriculaFuncionario = funcionarioService.buscarFuncionarioPorId(id);
        return ResponseEntity.ok(matriculaFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaFuncionarioDto> atualizarMatricula(@PathVariable Long id,
                                                                      @RequestBody MatriculaFuncionarioUtualizarDto funcionarioAtualizarDto) {

        MatriculaFuncionarioDto atualizarMatricula = funcionarioService.atualizarMatricula(id, funcionarioAtualizarDto);
        return ResponseEntity.ok(atualizarMatricula);
    }
}
