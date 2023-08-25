package br.com.morador.repository;

import br.com.morador.domain.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

    Optional<Proprietario> findByUuidProprietario(String uuid);

    @Transactional
    @Modifying
    @Query(value = """
            DELETE FROM condominio.tb_proprietario WHERE id = ?1
            """, nativeQuery = true)
    void deleteProprietario(Long id);
}
