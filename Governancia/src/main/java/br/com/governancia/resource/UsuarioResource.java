package br.com.governancia.resource;

import br.com.governancia.dto.*;
import br.com.governancia.infra.exception.exception.UsuarioNaoExisteException;
import br.com.governancia.infra.security.TokenService;
import br.com.governancia.service.UsuarioService;
import br.com.governancia.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@RequestMapping("/login")
public class UsuarioResource {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados) {
        UsernamePasswordAuthenticationToken Autenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        Authentication authentication = manager.authenticate(Autenticationtoken);

        String tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        var dataInicial = LocalDateTime.now();
        var dataFinal = LocalDateTime.now().plusHours(2);

        return ResponseEntity.ok(new DadosTokenJWT(dados.login(), tokenJWT, dataInicial, dataFinal));
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioDto usuario) {
        UsuarioDto retorno = usuarioService.crearUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioIdDto> buscarUsuarios(@PathVariable Long id) {
        UsuarioIdDto usuario = usuarioService.buscarUsuarioId(id);

        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<UsuarioListaDto>> listarUsuarios(@PageableDefault(size = 10, page = 0, sort = "nome") Pageable paginacao) {
        Page<UsuarioListaDto> listasPessoas = usuarioService.obterTodos(paginacao);

        return ResponseEntity.ok(listasPessoas);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody @Valid UsuarioDto usuario) {
        UsuarioAlteradoDto usuarioAlteradoDto = usuarioService.alterarUsuario(usuario);

        if (Objects.nonNull(usuarioAlteradoDto.getNome())) {
            return ResponseEntity.ok(usuarioAlteradoDto);
        }
        try {
            throw new UsuarioNaoExisteException();
        } catch (UsuarioNaoExisteException ex) {
            System.out.println("Solicitação negada!");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable @NotNull Long id){
        UsuarioDeletadoDto deletadoDto = usuarioService.deletarUsuario(id);

        return ResponseEntity.ok(deletadoDto);
    }

}
