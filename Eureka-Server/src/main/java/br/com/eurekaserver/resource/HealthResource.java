package br.com.eurekaserver.resource;

import br.com.eurekaserver.dto.Health;
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

    @Value("${spring.application.name}")
    private String nomeApi;

    @GetMapping
    public ResponseEntity<Health> health(){
        Health dados = this.gerarHealth();

        return ResponseEntity.ok(dados);
    }

    @Transient
    private Health gerarHealth() {
        return new Health(nomeApi, LocalDateTime.now(), HttpStatus.SC_OK);
    }
}
