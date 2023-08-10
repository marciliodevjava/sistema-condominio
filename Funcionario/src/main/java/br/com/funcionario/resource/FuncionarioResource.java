package br.com.funcionario.resource;

import br.com.funcionario.dto.AtualizarFuncionarioDto;
import br.com.funcionario.dto.FuncionarioDeletadoDto;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.FuncionarioRetornoDto;
import br.com.funcionario.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;

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
    public ResponseEntity<Page<FuncionarioRetornoDto>> listaFuncionario(@PageableDefault(size = 10, page = 0, sort = "id") Pageable paginacao) {
        Page<FuncionarioRetornoDto> retornoDtos = funcionarioService.obterTodos(paginacao);
        return ResponseEntity.ok(retornoDtos);
    }

    @PostMapping("/salvar-funcionario")
    public ResponseEntity<FuncionarioRetornoDto> salvarFuncionario(@RequestBody @Valid FuncionarioDto dto, UriComponentsBuilder uri) throws ParseException {
        FuncionarioRetornoDto funcionario = funcionarioService.salvarFuncionario(dto);
        URI endereco = uri.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(endereco).body(funcionario);
    }

    @PostMapping("/salvar-funcionario-completo")
    public ResponseEntity<FuncionarioRetornoDto> salvarFuncionarioCompleto(@RequestBody @Valid FuncionarioDto dto, UriComponentsBuilder uri) throws ParseException {
        FuncionarioRetornoDto funcionario = funcionarioService.salvarFuncionarioCompleto(dto);
        URI endereco = uri.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(endereco).body(funcionario);
    }

    @PutMapping("/atuaizar-funcionario/{id}")
    public ResponseEntity<FuncionarioRetornoDto> atualizarFuncionario(@PathVariable @NonNull Long id, @RequestBody AtualizarFuncionarioDto dto) throws ParseException {
        FuncionarioRetornoDto funcionario = funcionarioService.atualizarFuncionario(id, dto);
        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FuncionarioDeletadoDto> deletarFuncionario(@PathVariable Long id) {
        FuncionarioDeletadoDto funcionarioRetornoDto = funcionarioService.deletarUsuario(id);

        return ResponseEntity.ok(funcionarioRetornoDto);
    }

}
