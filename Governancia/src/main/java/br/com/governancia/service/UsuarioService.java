package br.com.governancia.service;

import br.com.governancia.dto.UsuarioAlteradoDto;
import br.com.governancia.dto.UsuarioDto;
import br.com.governancia.repository.UsuarioRepository;
import br.com.governancia.usuario.Usuario;
import br.com.governancia.utils.GeradorUuid;
import br.com.governancia.utils.HashUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Service
public class UsuarioService {

    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ObjectMapper objectMapper;

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

    public UsuarioAlteradoDto alterarUsuario(UsuarioDto usuario) {
        Usuario consultaUsuario = usuarioRepository.findByLoginAndNome(usuario.getLogin(), usuario.getNome());
        if(Objects.nonNull(consultaUsuario)){
            consultaUsuario = this.mapearUsuarioParaModificacao(consultaUsuario, usuario);
            consultaUsuario = usuarioRepository.save(consultaUsuario);

            return objectMapper.convertValue(consultaUsuario, UsuarioAlteradoDto.class);
        }

        return new UsuarioAlteradoDto();
    }

    private Usuario mapearUsuarioParaModificacao(Usuario consultaUsuario, UsuarioDto usuario) {

        String senha = HashUtil.getSecureHash(usuario.getSenha());

        consultaUsuario.setNome(usuario.getNome());
        consultaUsuario.setSenha(senha);

        return consultaUsuario;
    }
}
