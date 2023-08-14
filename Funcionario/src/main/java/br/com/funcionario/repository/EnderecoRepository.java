package br.com.funcionario.repository;

import br.com.funcionario.model.Endereco;
import br.com.funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findByFuncionario(Funcionario funcionario);

    void deleteByFuncionario(Optional<Funcionario> funcionario);

    Optional<Endereco> findByUuidIdentificador(String uuid);
}
