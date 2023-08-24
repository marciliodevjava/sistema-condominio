package br.com.morador.manager;

import br.com.morador.domain.Proprietario;
import br.com.morador.exception.ErroBuscarProprietarioException;
import br.com.morador.exception.ErroSalvarProprietarioException;
import br.com.morador.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class ProprietarioManager {
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public Proprietario salvarProprietario(Proprietario proprietario) {
        if (Objects.nonNull(proprietario)) {
            proprietario = proprietarioRepository.save(proprietario);
            return proprietario;
        }
        throw new ErroSalvarProprietarioException();
    }

    public Optional<Proprietario> buscarProprietario(String uuid) {
        if (Objects.nonNull(uuid)) {
            Optional<Proprietario> proprietario = proprietarioRepository.findByUuidProprietario(uuid);
            return proprietario;
        }
        throw new ErroBuscarProprietarioException();
    }
}
