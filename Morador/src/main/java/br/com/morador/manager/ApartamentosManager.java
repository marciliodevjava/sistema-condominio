package br.com.morador.manager;

import br.com.morador.domain.Apartamentos;
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

    public List<Apartamentos> salvarListApartamentos(List<Apartamentos> apartamento) {
        if (Objects.nonNull(apartamento)) {
            List<Apartamentos> apartamentos = apartamentosRepository.saveAll(apartamento);
            return apartamentos;
        }
        throw new ErroSalvarApartamentoException();
    }
}
