package br.com.morador.mapper;

import br.com.morador.domain.DependentesMorador;
import br.com.morador.domain.MoradorResponsavel;
import br.com.morador.dto.request.DependentesMoradorDto;
import br.com.morador.dto.request.DependentesMoradorUpdateDto;
import br.com.morador.dto.response.DependentesMoradorRetornoDto;
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
        if (Objects.nonNull(dependentes)) {
            dependentes.forEach(a -> {
                DependentesMorador dependentesMorador = new DependentesMorador();
                dependentesMorador.setUuidDependenteMorador(geradorUuid.gerarUuid());
                dependentesMorador.setNome(formatadorDadosDependentes.formatarNome(a.getNome()));
                dependentesMorador.setCpf(formatadorDadosDependentes.formatarCpf(a.getCpf()));
                dependentesMorador.setRg(formatadorDadosDependentes.formatarRg(a.getRg()));
                dependentesMorador.setDataNascimento(formatadorDadosDependentes.formatarStringParaDate(a.getDataNascimento()));
                dependentesMorador.setDddPais(formatadorDadosDependentes.formatarDddPais(a.getDddPais()));
                dependentesMorador.setDdd(formatadorDadosDependentes.formatarDdd(a.getDdd()));
                dependentesMorador.setTelefone(formatadorDadosDependentes.formatarTelefone(a.getTelefone()));
                dependentesMorador.setSexo(formatadorDadosDependentes.formatarSexo(a.getSexo()));
                dependentesMorador.setMoradorResponsavel(moradorResponsavel);
                listDependentes.add(dependentesMorador);
            });
            return listDependentes;
        }
        return null;
    }

    public List<DependentesMoradorRetornoDto> mapeiaDependentesRetornoDto(List<DependentesMorador> dependentes) {
        List<DependentesMoradorRetornoDto> list = new ArrayList<>();
        if (Objects.nonNull(dependentes)) {
            dependentes.forEach(dep -> {
                DependentesMoradorRetornoDto dto = new DependentesMoradorRetornoDto();
                dto.setUuidDependenteMorador(dep.getUuidDependenteMorador());
                dto.setNome(dep.getNome());
                dto.setCpf(dep.getCpf());
                dto.setRg(dep.getRg());
                dto.setDataNascimento(formatadorDadosDependentes.formatarDateParaString(dep.getDataNascimento()));
                dto.setDddPais(dep.getDddPais());
                dto.setDdd(dep.getDdd());
                dto.setTelefone(dep.getTelefone());
                dto.setSexo(dep.getSexo());
                list.add(dto);
            });
            return list;
        }
        return null;
    }

    public List<DependentesMorador> mapearDependentesUpdate(MoradorResponsavel morador, List<DependentesMorador> dependentes, List<DependentesMoradorUpdateDto> dto) {
        if (Objects.nonNull(dependentes) && Objects.nonNull(dto)) {
            dependentes.forEach(dep -> {
                dto.forEach(up -> {
                    if (dep.getUuidDependenteMorador().equals(up.getUuidDependenteMorador())) {
                        dep.setNome(!up.getNome().equals(null) && !up.getNome().isEmpty() ? formatadorDadosDependentes.formatarNome(up.getNome()) : dep.getNome());
                        dep.setCpf(!up.getCpf().equals(null) && !up.getCpf().isEmpty() ? formatadorDadosDependentes.formatarCpf(up.getCpf()) : dep.getCpf());
                        dep.setRg(!up.getRg().equals(null) && !up.getRg().isEmpty() ? formatadorDadosDependentes.formatarRg(up.getRg()) : dep.getRg());
                        dep.setDataNascimento(!up.getDataNascimento().equals(null) && !up.getDataNascimento().isEmpty() ? formatadorDadosDependentes.formatarStringParaDate(up.getDataNascimento()) : dep.getDataNascimento());
                        dep.setDddPais(!up.getDddPais().equals(null) && !up.getDddPais().isEmpty() ? formatadorDadosDependentes.formatarDddPais(up.getDddPais()) : dep.getDddPais());
                        dep.setDdd(!up.getDdd().equals(null) && !up.getDdd().isEmpty() ? formatadorDadosDependentes.formatarDdd(up.getDdd()) : dep.getDdd());
                        dep.setTelefone(!up.getTelefone().equals(null) && !up.getTelefone().isEmpty() ? formatadorDadosDependentes.formatarTelefone(up.getTelefone()) : dep.getTelefone());
                        dep.setSexo(!up.getSexo().equals(null) && !up.getSexo().toString().isEmpty() ? formatadorDadosDependentes.formatarSexo(up.getSexo()) : dep.getSexo());
                        dep.setMoradorResponsavel(morador);
                    }
                });
            });
            return dependentes;
        }
        return dependentes;
    }

    public DependentesMorador mapearDependentesList(MoradorResponsavel morador, DependentesMoradorDto dependentesMoradorDto) {
        DependentesMorador dependentes = new DependentesMorador();
        if (Objects.nonNull(dependentesMoradorDto)){
            dependentes.setUuidDependenteMorador(geradorUuid.gerarUuid());
            dependentes.setNome(formatadorDadosDependentes.formatarNome(dependentesMoradorDto.getNome()));
            dependentes.setCpf(formatadorDadosDependentes.formatarCpf(dependentes.getCpf()));
            dependentes.setRg(formatadorDadosDependentes.formatarRg(dependentesMoradorDto.getRg()));
            dependentes.setDataNascimento(formatadorDadosDependentes.formatarStringParaDate(dependentesMoradorDto.getDataNascimento()));
            dependentes.setDddPais(formatadorDadosDependentes.formatarDddPais(dependentesMoradorDto.getDddPais()));
            dependentes.setDdd(formatadorDadosDependentes.formatarDdd(dependentesMoradorDto.getDdd()));
            dependentes.setTelefone(formatadorDadosDependentes.formatarTelefone(dependentesMoradorDto.getTelefone()));
            dependentes.setSexo(formatadorDadosDependentes.formatarSexo(dependentesMoradorDto.getSexo()));
            dependentes.setMoradorResponsavel(morador);
            return dependentes;
        }
        return null;
    }

    public DependentesMoradorRetornoDto mapeiaDependentesRetornoDto(DependentesMorador dependentesMorador) {
        DependentesMoradorRetornoDto dto = new DependentesMoradorRetornoDto();
        if (Objects.nonNull(dependentesMorador)){
            dto.setUuidDependenteMorador(dependentesMorador.getUuidDependenteMorador());
            dto.setNome(dependentesMorador.getNome());
            dto.setCpf(dependentesMorador.getCpf());
            dto.setRg(dependentesMorador.getRg());
            dto.setDataNascimento(formatadorDadosDependentes.formatarDateParaString(dependentesMorador.getDataNascimento()));
            dto.setDddPais(dependentesMorador.getDddPais());
            dto.setDdd(dependentesMorador.getDdd());
            dto.setTelefone(dependentesMorador.getTelefone());
            dto.setSexo(dependentesMorador.getSexo());
            return dto;
        }
        return null;
    }
}
