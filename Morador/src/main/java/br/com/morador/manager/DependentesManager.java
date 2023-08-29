package br.com.morador.manager;

import br.com.morador.domain.DependentesMorador;
import br.com.morador.query.DependentesMoradorQuery;
import br.com.morador.repository.DependentesMoradorRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class DependentesManager {
    @Autowired
    private DependentesMoradorRepository dependentesMoradorRepository;
    @Autowired
    private DependentesMoradorQuery dependentesMoradorQuery;
    @Autowired
    private HttpServletRequest request;

    public DependentesMorador salvar(DependentesMorador dependentesMorador) {
        if (Objects.nonNull(dependentesMorador)){
            dependentesMorador = dependentesMoradorRepository.save(dependentesMorador);
            return dependentesMorador;
        }
        return null;
    }

    public Optional<DependentesMorador> buscar(String uuid) {
        if (uuid != null){
            DependentesMorador dependentesMorador = dependentesMoradorRepository.buscarUiid(uuid);
            return Optional.ofNullable(dependentesMorador);
        }
        return null;
    }
}
