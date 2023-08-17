package br.com.morador.mapper;

import br.com.morador.domain.DependentesMorador;
import br.com.morador.domain.MoradorResponsavel;
import br.com.morador.dto.DependentesMoradorDto;
import br.com.morador.utils.FormatadorDadosDependentes;
import br.com.morador.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DependentesMapper {
    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private FormatadorDadosDependentes formatadorDadosDependentes;

    public List<DependentesMorador> mapearDependentes(MoradorResponsavel moradorResponsavel, List<DependentesMoradorDto> dependentes) {
        List<DependentesMorador> listDependentes = new ArrayList<>();
        if (Objects.nonNull(dependentes)){
            dependentes.forEach(a -> {
                DependentesMorador dependentesMorador = new DependentesMorador();
                dependentesMorador.setUuidDependenteMorador(geradorUuid.gerarUuid());
                listDependentes.add(dependentesMorador);
            });
            return listDependentes;
        }
        return null;
    }
}
