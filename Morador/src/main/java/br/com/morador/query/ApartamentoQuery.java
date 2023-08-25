package br.com.morador.query;

import br.com.morador.domain.Apartamento;
import br.com.morador.repository.ApartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ApartamentoQuery {
    @Autowired
    private ApartamentosRepository apartamentosRepository;
    @Autowired
    private MoradorQuery moradorQuery;

    public void deletar(List<Apartamento> apartamento) {
        if (Objects.nonNull(apartamento)) {
            apartamento.forEach(apt -> {
                moradorQuery.deletar(apt.getMorador());
                Long id = apt.getId();
                apartamentosRepository.deleteApartamento(id);
            });
        }
    }
}
