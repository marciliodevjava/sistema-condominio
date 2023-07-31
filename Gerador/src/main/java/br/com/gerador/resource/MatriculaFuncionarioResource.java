package br.com.gerador.resource;

import br.com.gerador.dto.MatriculaFuncionarioDto;
import br.com.gerador.service.MatriculaFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gerador")
public class MatriculaFuncionarioResource {

    @Autowired
    private MatriculaFuncionarioService funcionarioService;

    @PostMapping("/{id}")
    public ResponseEntity<MatriculaFuncionarioDto> gerarMatricula(@PathVariable Long id){
        MatriculaFuncionarioDto matriculaFuncionario = funcionarioService.criarMatriculaFuncionarioService(id);
        return ResponseEntity.ok(matriculaFuncionario);
    }

    @GetMapping
    public ResponseEntity<MatriculaFuncionarioDto> getMatricula(@PathVariable Long id){
        return null;
    }
}
