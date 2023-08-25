package br.com.morador.query;

import br.com.morador.domain.Vagas;
import br.com.morador.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class VagasQuery {
    @Autowired
    private VagasRepository vagasRepository;

    public void deletar(List<Vagas> vagas) {
        if (Objects.nonNull(vagas)){
            vagas.forEach( vap -> {
                Long id = vap.getId();
                vagasRepository.deleteVagas(id);
            });
        }
    }
}
