package br.com.funcionario.resource;

import br.com.funcionario.dto.EnderecoRetornoDto;
import br.com.funcionario.service.EnderecoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
