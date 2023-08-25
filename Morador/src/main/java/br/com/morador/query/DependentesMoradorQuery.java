package br.com.morador.query;

import br.com.morador.domain.DependentesMorador;
import br.com.morador.repository.DependentesMoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class DependentesMoradorQuery {
    @Autowired
    private DependentesMoradorRepository dependentesMoradorRepository;

    public void deletar(List<DependentesMorador> dependentes) {
        if (Objects.nonNull(dependentes)){
            dependentes.forEach( dep -> {
                Long id = dep.getId();
                dependentesMoradorRepository.deletarDependente(id);
            });
        }
    }
}
