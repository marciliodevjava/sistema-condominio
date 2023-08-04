package br.com.governancia.dto;

import java.time.LocalDateTime;

public record DadosTokenJWT(String login, String tokenJWT, LocalDateTime dataInicial, LocalDateTime dataFinal) {
}
