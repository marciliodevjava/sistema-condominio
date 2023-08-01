package br.com.gerador.dto;

import org.springframework.http.ResponseEntity;

public class ErrosDto {

    private String mensagem;
    private Long codigo;
    private Long identificador;

    public ErrosDto(String mensagem, Long id) {
        this.mensagem = mensagem;
        this.identificador = id;
        this.codigo = 200L;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }
}
