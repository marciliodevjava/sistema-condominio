package br.com.funcionario.repository;

import br.com.funcionario.model.Endereco;
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
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByFuncionario(Funcionario funcionario);

    @Transactional
    @Modifying
    @Query(value = """
            SELECT * FROM condominio.tb_enderecos WHERE id_funcionario = ?1
            """, nativeQuery = true)
    List<Endereco> findByListFuncionario(@PathVariable Long id);

    void deleteByFuncionario(Optional<Funcionario> funcionario);

    Optional<Endereco> findByUuidIdentificador(String uuid);
    void deleteByUuidIdentificador(String uuid);
}
