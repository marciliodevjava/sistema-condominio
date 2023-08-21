package br.com.morador.manager;

import br.com.morador.domain.Apartamentos;
import br.com.morador.exception.ErroSalvarApartamentoException;
import br.com.morador.repository.ApartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ApartamentosManager {
    @Autowired
    private ApartamentosRepository apartamentosRepository;

    public List<Apartamentos> salvarListApartamentos(List<Apartamentos> apartamento) {
        List<Apartamentos> listApt = new ArrayList<>(apartamento);
        if (Objects.nonNull(apartamento)) {
            listApt = apartamentosRepository.saveAll(listApt);
            return listApt;
        }
        throw new ErroSalvarApartamentoException();
    }
}
