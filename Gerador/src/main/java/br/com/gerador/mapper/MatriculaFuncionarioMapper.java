package br.com.gerador.mapper;

import br.com.gerador.domain.MatriculaFuncionario;
import br.com.gerador.domain.enuns.EnumAtivo;
import br.com.gerador.repository.MatriculaFuncionarioRepository;
import br.com.gerador.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

@Component
public class MatriculaFuncionarioMapper {

    @Autowired
    private MatriculaFuncionarioRepository matriculaFuncionarioRepository;

    @Autowired
    private GeradorUuid geradorUuid;

    public MatriculaFuncionario gerarFuncionario(Long id) {
        MatriculaFuncionario consulta = matriculaFuncionarioRepository.findTopByOrderByIdDesc();
        Integer matricula;

        if (Objects.isNull(consulta)) {
            matricula = 1;
        } else {
            matricula = consulta.getNumeroFuncionario();
        }

        MatriculaFuncionario inserirFuncionario = this.montarDados(matricula, id);

        return inserirFuncionario;
    }

    private MatriculaFuncionario montarDados(Integer matricula, Long id) {
        MatriculaFuncionario matriculaFuncionarioInserir = new MatriculaFuncionario();

        LocalTime hora = LocalTime.now();
        LocalDate data = LocalDate.now();
        matricula += 1;

        matriculaFuncionarioInserir.setUuidIdentificador(geradorUuid.getIdentificadorUuid());
        matriculaFuncionarioInserir.setNumeroFuncionario(matricula);
        matriculaFuncionarioInserir.setData(LocalDate.now());
        matriculaFuncionarioInserir.setHora(LocalTime.now());
        matriculaFuncionarioInserir.setIdFuncionario(Integer.valueOf(Math.toIntExact(id)));
        matriculaFuncionarioInserir.setAtivo(EnumAtivo.ATIVO);

        return matriculaFuncionarioInserir;
    }
}
