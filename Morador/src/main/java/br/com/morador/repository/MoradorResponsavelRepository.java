package br.com.morador.repository;

import br.com.morador.domain.MoradorResponsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface MoradorResponsavelRepository extends JpaRepository<MoradorResponsavel, Long> {
    @Transactional
    @Modifying
    @Query(value = """
            DELETE FROM condominio.tb_morador_responsavel WHERE id = ?1
            """, nativeQuery = true)
    void deleteMorador(@PathVariable Long id);

    Optional<MoradorResponsavel> findByUuidMorador(String uuid);
}
