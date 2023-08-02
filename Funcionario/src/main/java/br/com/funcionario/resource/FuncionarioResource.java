package br.com.funcionario.resource;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.FuncionarioRetornoDto;
import br.com.funcionario.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioRetornoDto> listaFuncionarioId(@PathVariable Long id) {
        FuncionarioRetornoDto funcionario = funcionarioService.buscarFuncionarioId(id);
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioDto>> listaFuncionario() {
        return null;
    }

    @PostMapping("/salvar-funcionario")
    public ResponseEntity<FuncionarioRetornoDto> salvarFuncionario(@RequestBody @Valid FuncionarioDto dto, UriComponentsBuilder uri) throws ParseException {
        FuncionarioRetornoDto funcionario = funcionarioService.salvarFuncionario(dto);
        URI endereco = uri.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(endereco).body(funcionario);
    }

    @PutMapping("/atuaizar-funcionario/{id}")
    public ResponseEntity<FuncionarioDto> atualizarFuncionario(@PathVariable @NonNull Long id, @RequestBody FuncionarioDto dto) {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<FuncionarioDto> deletarFuncionario(@PathVariable Long id) {
        return null;
    }

}
