package br.com.morador.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponse {
    private int status;
    private List<String> mensagem;
    private String timestamp;
    private String endpoint;
    private String projeto;
}
