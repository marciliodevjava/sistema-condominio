package br.com.morador.infra;

import br.com.morador.dto.ErroSalvarDependenteException;
import br.com.morador.exception.*;
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

        erro.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        erro.setMensagem(Collections.singletonList(MensagemEnum.ERRO_SALVAR_PROPRIETARIO_SIMPLES.getMensagem()));
        erro.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        erro.setEndpoint(request.getRequestURI());
        erro.setProjeto(projeto);

        return new ResponseEntity<>(erro, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ErroBuscarProprietarioException.class)
    public ResponseEntity<ErroResponse> erroBuscarProprietario(ErroBuscarProprietarioException ex) {
        ErroResponse erro = new ErroResponse();

        erro.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        erro.setMensagem(Collections.singletonList(MensagemEnum.ERRO_BUSCAR_PROPRIETARIO.getMensagem()));
        erro.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-HH-dd HH:mm:ss")));
        erro.setEndpoint(request.getRequestURI());
        erro.setProjeto(projeto);

        return new ResponseEntity<>(erro, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ErroSalvarApartamentoException.class)
    public ResponseEntity<ErroResponse> erroSalvarApartamento(ErroSalvarApartamentoException ex) {
        ErroResponse erro = new ErroResponse();

        erro.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        erro.setMensagem(Collections.singletonList(MensagemEnum.ERRO_SALVAR_APARTAMENTO.getMensagem()));
        erro.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        erro.setEndpoint(request.getRequestURI());
        erro.setProjeto(projeto);

        return new ResponseEntity<>(erro, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ErroSalvarDependenteException.class)
    public ResponseEntity<ErroResponse> erroSalvarDependente(ErroSalvarDependenteException ex){
        ErroResponse response = new ErroResponse();

        response.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        response.setMensagem(Collections.singletonList(MensagemEnum.ERRO_SALVAR_DEPENDENTE.getMensagem()));
        response.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        response.setEndpoint(request.getRequestURI());
        response.setProjeto(projeto);

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ErroDeletarProprietarioException.class)
    public ResponseEntity<ErroResponse> erroDeletarProprietario(ErroDeletarProprietarioException ex) {
        ErroResponse erro = new ErroResponse();

        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setMensagem(Collections.singletonList(MensagemEnum.ERRO_DELETAR_PROPRIETARIO.getMensagem()));
        erro.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        erro.setEndpoint(request.getRequestURI());
        erro.setProjeto(projeto);

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErroBuscarDependenteExcepton.class)
    public ResponseEntity<ErroResponse> erroBuscarDepentende(ErroBuscarDependenteExcepton ex){
        ErroResponse erroResponse = new ErroResponse();

        erroResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        erroResponse.setMensagem(Collections.singletonList(MensagemEnum.ERRO_BUSCAR_DEPENDENTE.getMensagem()));
        erroResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        erroResponse.setEndpoint(request.getRequestURI());
        erroResponse.setProjeto(projeto);

        return new ResponseEntity<>(erroResponse, HttpStatus.BAD_REQUEST);
    }
}
