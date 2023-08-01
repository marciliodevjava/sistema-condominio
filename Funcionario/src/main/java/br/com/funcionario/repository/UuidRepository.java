package br.com.funcionario.repository;

import br.com.funcionario.model.Uuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UuidRepository extends JpaRepository<Uuid, Long> {

   Uuid findByUuidGerado(String uuidGerador);
}
