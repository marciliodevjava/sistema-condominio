package br.com.morador.service;

import br.com.morador.domain.DependentesMorador;
import br.com.morador.domain.MoradorResponsavel;
import br.com.morador.dto.ErroSalvarDependenteException;
import br.com.morador.dto.request.DependentesMoradorDto;
import br.com.morador.dto.response.DependentesMoradorRetornoDto;
import br.com.morador.manager.DependentesManager;
import br.com.morador.mapper.DependentesMapper;
import br.com.morador.repository.MoradorResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DependentesMoradorService {
    @Autowired
    private DependentesMapper dependentesMapper;
    @Autowired
    private DependentesManager dependentesManager;
    @Autowired
    private MoradorResponsavelRepository moradorResponsavelRepository;

    public DependentesMoradorRetornoDto salvarDependente(String uuid, DependentesMoradorDto dependentesMoradorDto) {
        Optional<MoradorResponsavel> responsavel = moradorResponsavelRepository.findByUuidMorador(uuid);
        if (!responsavel.isEmpty()){
            throw new ErroSalvarDependenteException();
        }
        DependentesMorador dependentesMorador = dependentesMapper.mapearDependentesList(responsavel.get(), dependentesMoradorDto);
        if (dependentesMorador != null){
            dependentesMorador = dependentesManager.salvar(dependentesMorador);
            return dependentesMapper.mapeiaDependentesRetornoDto(dependentesMorador);
        }
        return null;
    }
}
