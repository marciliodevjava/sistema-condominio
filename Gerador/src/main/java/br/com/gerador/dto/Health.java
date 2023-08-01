package br.com.gerador.dto;

import java.time.LocalDateTime;

public record Health(String api, LocalDateTime dataHora, int codigo) {
}
