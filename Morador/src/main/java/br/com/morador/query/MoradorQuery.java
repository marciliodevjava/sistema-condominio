package br.com.morador.query;

import br.com.morador.domain.MoradorResponsavel;
import br.com.morador.repository.MoradorResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MoradorQuery {
    @Autowired
    private MoradorResponsavelRepository moradorResponsavelRepository;
    @Autowired
    private DependentesMoradorQuery dependentesMoradorQuery;
    @Autowired
    private VagasQuery vagasQuery;

    public void deletar(MoradorResponsavel morador) {
        if (Objects.nonNull(morador)){
            dependentesMoradorQuery.deletar(morador.getDependentes());
            vagasQuery.deletar(morador.getVagas());
            Long id = morador.getId();
            moradorResponsavelRepository.deleteMorador(id);
        }
    }
}
