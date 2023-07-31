package br.com.gerador.repository;

import br.com.gerador.domain.Uuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UuidRepository extends JpaRepository<Uuid, Long> {

    Uuid findByUuidGerado(String uuidGerado);
}
