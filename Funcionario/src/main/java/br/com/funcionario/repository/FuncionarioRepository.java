package br.com.funcionario.repository;

import br.com.funcionario.model.Funcionario;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Transactional
    @Modifying
    @Query(value = """
            DELETE FROM condominio.tb_funcionarios WHERE id = ?1

                        """, nativeQuery = true)
    void deletarFuncionario(@PathVariable Long id);
}
