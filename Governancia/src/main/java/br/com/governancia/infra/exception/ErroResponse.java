package br.com.governancia.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErroResponse {

    private int status;
    private List<String> mensagem;
    private String timestamp;
    private String endpoint;
    private String projeto;
}
