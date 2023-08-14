package br.com.funcionario.infra.exception;

import br.com.funcionario.infra.exception.enuns.MensagemEnum;
import br.com.funcionario.infra.exception.exception.AtualizarDependenteNotFouldException;
import br.com.funcionario.infra.exception.exception.ErroDeletarFuncionarioException;
import br.com.funcionario.infra.exception.exception.FuncionarioNaoExisteException;
import br.com.funcionario.infra.exception.exception.ListDependenteNotFouldException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@RestControllerAdvice
public class TratadorDeErros {
    private final String projetoNome = "Api Funcionario";
    @Value("${spring.application.name}")
    private String projeto;
    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(ErroDeletarFuncionarioException.class)
    public ResponseEntity<ErroResponse> errorDeletarFuncionarioCmpleto(ErroDeletarFuncionarioException ex) {
        ErroResponse erroResponse = new ErroResponse();

        erroResponse.setStatus(HttpStatus.OK.value());
        erroResponse.setMensagem(Collections.singletonList(MensagemEnum.ERRO_DELETAR_FUNCIONARIO_COMPLETO.getMensagem()));
        erroResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        erroResponse.setEndpoint(request.getRequestURI());
        erroResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(erroResponse, HttpStatus.OK);
    }

    @ExceptionHandler(ListDependenteNotFouldException.class)
    public ResponseEntity<ErroResponse> listDependeteNotFound(ListDependenteNotFouldException ex) {
        ErroResponse erroResponse = new ErroResponse();

        erroResponse.setStatus(HttpStatus.OK.value());
        erroResponse.setMensagem(Collections.singletonList(MensagemEnum.LIST_DEPENDENTE_NOT_FOUND.getMensagem()));
        erroResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        erroResponse.setEndpoint(request.getRequestURI());
        erroResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(erroResponse, HttpStatus.OK);
    }

    @ExceptionHandler(AtualizarDependenteNotFouldException.class)
    public ResponseEntity<ErroResponse> naoFoiPossivelAtualizarDependente(AtualizarDependenteNotFouldException ex) {
        ErroResponse erroResponse = new ErroResponse();

        erroResponse.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        erroResponse.setMensagem(Collections.singletonList(MensagemEnum.ERRO_AO_ATUALIZAR_DEPENDENTE.getMensagem()));
        erroResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        erroResponse.setEndpoint(request.getRequestURI());
        erroResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(erroResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(FuncionarioNaoExisteException.class)
    public ResponseEntity<ErroResponse> funcionarioNaoExiste(FuncionarioNaoExisteException ex){
        ErroResponse erroResponse = new ErroResponse();

        erroResponse.setStatus(HttpStatus.NOT_FOUND.value());
        erroResponse.setMensagem(Collections.singletonList(MensagemEnum.ERRO_FUNCIONARIO_NAO_EXISTE.getMensagem()));
        erroResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        erroResponse.setEndpoint(request.getRequestURI());
        erroResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(erroResponse, HttpStatus.NOT_FOUND);
    }
}
