package br.com.morador.repository;

import br.com.morador.domain.Uuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UuidRepository extends JpaRepository<Uuid, Long> {
    Uuid findByUuidGerado(String uuid);
}
