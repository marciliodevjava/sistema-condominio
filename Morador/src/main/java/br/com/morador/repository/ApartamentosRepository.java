package br.com.morador.repository;

import br.com.morador.domain.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentosRepository extends JpaRepository<Apartamento, Long> {
}
