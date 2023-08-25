package br.com.morador.query;

import br.com.morador.domain.Proprietario;
import br.com.morador.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProprietarioQuery {
    @Autowired
    private ProprietarioRepository proprietarioRepository;
    @Autowired
    private ApartamentoQuery apartamentoQuery;

    public boolean deletar(Proprietario pro) {
        if (Objects.nonNull(pro)){
            apartamentoQuery.deletar(pro.getApartamento());
            Long id = pro.getId();
            proprietarioRepository.deleteProprietario(id);
            return true;
        }
        return false;
    }
}
