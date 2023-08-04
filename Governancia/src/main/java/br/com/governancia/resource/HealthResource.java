package br.com.governancia.resource;

import br.com.governancia.dto.HealthDto;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Transient;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/health")
public class HealthResource {

    @Value("gerador-ms")
    private String nomeApi;

    @GetMapping
    public ResponseEntity<HealthDto> health() {
        return ResponseEntity.ok(this.gerarHealth());
    }

    @Transient
    private HealthDto gerarHealth() {
        return new HealthDto(nomeApi, LocalDateTime.now(), HttpStatus.SC_OK);
    }

}
