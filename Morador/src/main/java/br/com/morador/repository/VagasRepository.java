package br.com.morador.repository;

import br.com.morador.domain.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagasRepository extends JpaRepository<Vagas, Long> {
}
