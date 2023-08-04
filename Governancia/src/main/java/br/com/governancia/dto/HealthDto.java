package br.com.governancia.dto;

import java.time.LocalDateTime;

public record HealthDto(String api, LocalDateTime dataHora, int codigo) {
}
