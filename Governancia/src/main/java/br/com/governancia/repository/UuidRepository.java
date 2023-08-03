package br.com.governancia.repository;

import br.com.governancia.usuario.Uuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UuidRepository extends JpaRepository<Uuid, Long> {

    Uuid findByUuidGerado(String uuidGerador);
}

