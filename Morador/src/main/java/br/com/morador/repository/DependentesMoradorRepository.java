package br.com.morador.repository;

import br.com.morador.domain.DependentesMorador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentesMoradorRepository extends JpaRepository<DependentesMorador, Long> {
}
