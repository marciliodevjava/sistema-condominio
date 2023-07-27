package br.com.gerador.repository;

import br.com.gerador.domain.MatriculaFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaFuncionarioRepository extends JpaRepository<MatriculaFuncionario, Long> {

    MatriculaFuncionario findByIdFuncionario(Long id);

    MatriculaFuncionario findTopByOrderByIdDesc();
}
