package br.com.morador.repository;

import br.com.morador.domain.MoradorResponsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorResponsavelRepository extends JpaRepository<MoradorResponsavel, Long> {
}
