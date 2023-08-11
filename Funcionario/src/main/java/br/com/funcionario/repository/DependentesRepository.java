package br.com.funcionario.repository;

import br.com.funcionario.model.Dependentes;
import br.com.funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface DependentesRepository extends JpaRepository<Dependentes, Long> {

    List<Dependentes> findByFuncionario(Funcionario funcionario);
    Dependentes findByUuidIdentificador(String uuid);
    @Transactional
    @Modifying
    @Query(value = """
            SELECT * FROM condominio.tb_dependentes WHERE id_funcionario = ?1

                        """, nativeQuery = true)
    List<Dependentes> listDepentende(@PathVariable Long id);
}
