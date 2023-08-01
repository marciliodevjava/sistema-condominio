package br.com.gerador.resource;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.gerador.dto.Health;

import java.beans.Transient;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/health")
public class HealthResource {

    @Value("${spring.application.name}")
    private String nomeApi;

    @GetMapping
    public ResponseEntity<Health> health(){
        return ResponseEntity.ok(this.gerarHealth());
    }

    @Transient
    private br.com.gerador.dto.Health gerarHealth() {
        return new Health(nomeApi, LocalDateTime.now(), HttpStatus.SC_OK);
    }
}
