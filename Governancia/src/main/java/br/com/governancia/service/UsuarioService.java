package br.com.governancia.service;

import br.com.governancia.dto.UsuarioAlteradoDto;
import br.com.governancia.dto.UsuarioDto;
import br.com.governancia.dto.UsuarioIdDto;
import br.com.governancia.dto.UsuarioListaDto;
import br.com.governancia.infra.exception.exception.UsuarioNaoExisteException;
import br.com.governancia.infra.exception.exception.UsuarioNaoIdExisteException;
import br.com.governancia.repository.UsuarioRepository;
import br.com.governancia.usuario.Usuario;
import br.com.governancia.utils.GeradorUuid;
import br.com.governancia.utils.HashUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
        if (Objects.nonNull(consultaUsuario)) {
            consultaUsuario = this.mapearUsuarioParaModificacao(consultaUsuario, usuario);
            consultaUsuario = usuarioRepository.save(consultaUsuario);

            return objectMapper.convertValue(consultaUsuario, UsuarioAlteradoDto.class);
        }

        if (Objects.isNull(consultaUsuario)){
            throw new UsuarioNaoExisteException();
        }
        return new UsuarioAlteradoDto();
    }

    private Usuario mapearUsuarioParaModificacao(Usuario consultaUsuario, UsuarioDto usuario) {

        String senha = HashUtil.getSecureHash(usuario.getSenha());

        consultaUsuario.setNome(usuario.getNomeAtualizado());
        consultaUsuario.setSenha(senha);

        return consultaUsuario;
    }

    public Page<UsuarioListaDto> obterTodos(Pageable paginacao) {
        Page<Usuario> usuario = usuarioRepository.findAll(paginacao);
        List<UsuarioListaDto> usuarioDtos = usuario.getContent().stream()
                .map(this::mapToUsuarioListaDto)
                .collect(Collectors.toList());

        return new PageImpl<>(usuarioDtos, paginacao, usuario.getTotalElements());
    }

    private UsuarioListaDto mapToUsuarioListaDto(Usuario usuario) {
        UsuarioListaDto usuarioListaDto = new UsuarioListaDto();

        usuarioListaDto.setId(usuario.getId());
        usuarioListaDto.setNome(usuario.getNome());
        usuarioListaDto.setLogin(usuario.getLogin());

        return usuarioListaDto;
    }

    public UsuarioIdDto buscarUsuarioId(Long id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()){
            throw new UsuarioNaoIdExisteException("Usuario não existe: " + id);
        }

        return objectMapper.convertValue(usuario, UsuarioIdDto.class);
    }
}
