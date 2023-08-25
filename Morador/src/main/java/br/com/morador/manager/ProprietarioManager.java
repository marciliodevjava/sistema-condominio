package br.com.morador.manager;

import br.com.morador.domain.Proprietario;
import br.com.morador.dto.ProprietarioDeletadoDto;
import br.com.morador.exception.ErroBuscarProprietarioException;
import br.com.morador.exception.ErroSalvarProprietarioException;
import br.com.morador.query.ProprietarioQuery;
import br.com.morador.repository.ProprietarioRepository;
import br.com.morador.utils.FormatadorDadosProprietario;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Component
public class ProprietarioManager {
    @Autowired
    private ProprietarioRepository proprietarioRepository;
    @Autowired
    private ProprietarioQuery proprietarioQuery;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FormatadorDadosProprietario formatadorDadosProprietario;

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

    public ProprietarioDeletadoDto deletaProprietario(Optional<Proprietario> proprietario) {
        Proprietario pro = proprietario.get();
        if (Objects.nonNull(proprietario)){
            boolean suceso = proprietarioQuery.deletar(pro);
            if (suceso){
                return new ProprietarioDeletadoDto("Proprietário deletado com Sucesso!", LocalDate.now(), 200, request.getRequestURI());
            }
        }
        return null;
    }
}
