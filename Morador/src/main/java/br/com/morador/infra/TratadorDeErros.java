package br.com.morador.infra;

import br.com.morador.exception.ErroSalvarProprietarioException;
import br.com.morador.infra.enuns.MensagemEnum;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@RestControllerAdvice
public class TratadorDeErros {
    @Value("${spring.application.name}")
    private String projeto;
    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(ErroSalvarProprietarioException.class)
    public ResponseEntity<ErroResponse> erroSalvarProprietario(ErroSalvarProprietarioException ex) {
        ErroResponse erro = new ErroResponse();

        erro.setStatus(HttpStatus.PROCESSING.value());
        erro.setMensagem(Collections.singletonList(MensagemEnum.ERRO_SALVAR_PROPRIETARIO_SIMPLES.getMensagem()));
        erro.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        erro.setEndpoint(request.getRequestURI());
        erro.setProjeto(projeto);

        return new ResponseEntity<>(erro, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
