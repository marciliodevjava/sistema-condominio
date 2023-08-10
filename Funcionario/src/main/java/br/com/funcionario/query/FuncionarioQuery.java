package br.com.funcionario.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FuncionarioQuery {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void deletaFuncionario(Long id) {
        if (id != null && id > 0 && id instanceof Long) {

            // Primeiro, exclua os dependentes
            Query deletaDependentes = entityManager.createNativeQuery("DELETE FROM condominio.tb_dependentes WHERE id_funcionario = ?");
            deletaDependentes.setParameter(1, id);
            deletaDependentes.executeUpdate();

            // Em seguida, exclua os endereços
            Query deletaEndereco = entityManager.createNativeQuery("DELETE FROM condominio.tb_enderecos WHERE id_funcionario = ?");
            deletaEndereco.setParameter(1, id);
            deletaEndereco.executeUpdate();

            // Depois, exclua as matrículas dos funcionários
            Query deletaMatriculaFuncionario = entityManager.createNativeQuery("DELETE FROM condominio.tb_matricula_funcionarios WHERE id_funcionario = ?");
            deletaMatriculaFuncionario.setParameter(1, id);
            deletaMatriculaFuncionario.executeUpdate();

            // Por fim, exclua o próprio funcionário
            Query deletaFuncionario = entityManager.createNativeQuery("DELETE FROM condominio.tb_funcionarios WHERE id = ?");
            deletaFuncionario.setParameter(1, id);
            deletaFuncionario.executeUpdate();
        }
    }
}