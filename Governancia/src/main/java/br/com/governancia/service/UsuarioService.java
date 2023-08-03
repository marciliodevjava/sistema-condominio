package br.com.governancia.service;

import br.com.governancia.dto.UsuarioDto;
import br.com.governancia.repository.UsuarioRepository;
import br.com.governancia.usuario.Usuario;
import br.com.governancia.utils.GeradorUuid;
import br.com.governancia.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;

@Service
public class UsuarioService {

    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto crearUsuario(UsuarioDto usuario) {
        Usuario criarUsuario = this.montarUsuario(usuario);
        criarUsuario = usuarioRepository.save(criarUsuario);
        UsuarioDto retorno = this.montarUsuarioDto(criarUsuario);

        return retorno;
    }

    private UsuarioDto montarUsuarioDto(Usuario criarUsuario) {
        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setLogin(criarUsuario.getLogin());
        usuarioDto.setNome(criarUsuario.getNome());

        return usuarioDto;
    }

    private Usuario montarUsuario(UsuarioDto usuario) {
        Usuario criarUsuario = new Usuario();

        String senha = HashUtil.getSecureHash(usuario.getSenha());

        criarUsuario.setNome(usuario.getNome());
        criarUsuario.setLogin(usuario.getLogin());
        criarUsuario.setSenha(senha);
        criarUsuario.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
        criarUsuario.setData(new Date());
        criarUsuario.setHora(LocalTime.now());

        return criarUsuario;
    }
}
