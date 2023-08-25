package br.com.morador.repository;

import br.com.morador.domain.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface VagasRepository extends JpaRepository<Vagas, Long> {

    @Transactional
    @Modifying
    @Query(value = """ 
            SELECT * FROM dbo.condominio.tb_vagas WHERE id = ?1 ORDER BY id DESC
            """, nativeQuery = true)
    Optional<Vagas> buscarVagas(@PathVariable Long id);

    @Transactional
    @Modifying
    @Query(value = """ 
            DELETE FROM condominio.tb_vagas WHERE id = ?1
             """, nativeQuery = true)
    void deleteVagas(@PathVariable Long id);
}
