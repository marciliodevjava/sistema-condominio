package br.com.funcionario.repository;

import br.com.funcionario.model.Dependentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependentesRepository extends JpaRepository<Dependentes, Long> {

    List<Dependentes> findByFuncionario(Long id);
}
