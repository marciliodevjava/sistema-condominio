package br.com.gerador.resource;

import br.com.gerador.dto.ErrosDto;
import br.com.gerador.dto.MatriculaFuncionarioAtualizarDto;
import br.com.gerador.dto.MatriculaFuncionarioDto;
import br.com.gerador.service.MatriculaFuncionarioService;
import br.com.gerador.utils.LoggerUltis;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/gerador")
public class MatriculaFuncionarioResource {

    private final String IDENTIFICADOR = "IDENTIFICADOR";
    @Autowired
    private MatriculaFuncionarioService funcionarioService;
    @Autowired
    private LoggerUltis logger;

    @PostMapping("/{id}")
    public ResponseEntity<MatriculaFuncionarioDto> gerarMatricula(@PathVariable @NotNull Long id, UriComponentsBuilder uri) {
        logger.logInfo("Iniciando o processamento de dados: gerarMatricula", String.valueOf(id));
        MatriculaFuncionarioDto matriculaFuncionario = funcionarioService.criarMatriculaFuncionarioService(id);
        URI retorno = uri.path("/gerador/{id}").buildAndExpand(matriculaFuncionario.getId()).toUri();
        return ResponseEntity.created(retorno).body(matriculaFuncionario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMatricula(@PathVariable Long id) {
        MatriculaFuncionarioDto matriculaFuncionario = funcionarioService.buscarFuncionarioPorId(id);
        if (Objects.isNull(matriculaFuncionario)) return ResponseEntity.ok(new ErrosDto("Matricula não existe.", id));
        return ResponseEntity.ok(matriculaFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaFuncionarioDto> atualizarMatricula(@PathVariable Long id,
                                                                      @RequestBody MatriculaFuncionarioAtualizarDto funcionarioAtualizarDto) {

        MatriculaFuncionarioDto atualizarMatricula = funcionarioService.atualizarMatricula(id, funcionarioAtualizarDto);
        return ResponseEntity.ok(atualizarMatricula);
    }
}
