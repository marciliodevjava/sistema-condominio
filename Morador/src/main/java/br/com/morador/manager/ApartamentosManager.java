package br.com.morador.manager;

import br.com.morador.domain.Apartamento;
import br.com.morador.exception.ErroSalvarApartamentoException;
import br.com.morador.repository.ApartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ApartamentosManager {
    @Autowired
    private ApartamentosRepository apartamentosRepository;

    public List<Apartamento> salvarListApartamentos(List<Apartamento> apartamento) {
        if (Objects.nonNull(apartamento)) {
            apartamento = apartamentosRepository.saveAll(apartamento);
            return apartamento;
        }
        throw new ErroSalvarApartamentoException();
    }
}
