package br.com.governancia.resource;

import br.com.governancia.dto.DadosAutenticacaoDto;
import br.com.governancia.dto.DadosTokenJWT;
import br.com.governancia.dto.UsuarioDto;
import br.com.governancia.infra.security.TokenService;
import br.com.governancia.service.UsuarioService;
import br.com.governancia.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados){
        UsernamePasswordAuthenticationToken Autenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        Authentication authentication = manager.authenticate(Autenticationtoken);

        String tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        var dataInicial = LocalDateTime.now();
        var dataFinal = LocalDateTime.now().plusHours(2);

        return ResponseEntity.ok(new DadosTokenJWT(dados.login(), tokenJWT, dataInicial, dataFinal));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioDto usuario){
        UsuarioDto retorno = usuarioService.crearUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
}
