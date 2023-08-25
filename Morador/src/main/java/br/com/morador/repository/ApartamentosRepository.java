package br.com.morador.repository;

import br.com.morador.domain.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface ApartamentosRepository extends JpaRepository<Apartamento, Long> {
    @Modifying
    @Transactional
    @Query(value = """
            DELETE FROM condominio.tb_apartamento WHERE id = ?1
            """, nativeQuery = true)
    void deleteApartamento(@PathVariable Long id);
}
