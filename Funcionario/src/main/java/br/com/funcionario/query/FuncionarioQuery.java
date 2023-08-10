package br.com.funcionario.query;

import br.com.funcionario.model.Dependentes;
import br.com.funcionario.model.Endereco;
import br.com.funcionario.model.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Component
public class FuncionarioQuery {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void deletaFuncionario(Long id) {
        boolean existe = false;
        if (id != null && id > 0 && id instanceof Long) {

            // Primeiro, consulte os dependentes
            Query consultaDependentes = entityManager.createNativeQuery("SELECT * FROM condominio.tb_dependentes WHERE id_funcionario = ?", Dependentes.class);
            consultaDependentes.setParameter(1, id);
            try{
                Dependentes dependentes = (Dependentes) consultaDependentes.getSingleResult();

                if (Objects.nonNull(dependentes)) {
                    // Primeiro, exclua os dependentes
                    Query deletaDependentes = entityManager.createNativeQuery("DELETE FROM condominio.tb_dependentes WHERE id_funcionario = ?");
                    deletaDependentes.setParameter(1, id);
                    deletaDependentes.executeUpdate();
                    existe = true;
                }
            } catch (NoResultException ex){
                System.out.println("Não existe dados de Dependente ID:" + id);
            }

            // Em seguida, consulte os endereços
            Query consultaEndereco = entityManager.createNativeQuery("SELECT * FROM condominio.tb_enderecos WHERE id_funcionario = ?");
            consultaEndereco.setParameter(1, id);
            try{
                Endereco endereco = (Endereco) consultaEndereco.getSingleResult();

                if (Objects.nonNull(endereco)) {
                    // Em seguida, exclua os endereços
                    Query deletaEndereco = entityManager.createNativeQuery("DELETE FROM condominio.tb_enderecos WHERE id_funcionario = ?");
                    deletaEndereco.setParameter(1, id);
                    deletaEndereco.executeUpdate();
                    existe = true;
                }
            } catch (NoResultException ex){
                System.out.println("Não existe dados de Endereco ID:" + id);
            }

            // Depois, consulta as matrículas dos funcionários
            Query consultaMatriculaFuncionario = entityManager.createNativeQuery("SELECT * FROM condominio.tb_matricula_funcionarios WHERE id_funcionario = ?");
            consultaMatriculaFuncionario.setParameter(1, id);
            try{
                Object matriculaFuncionario = consultaMatriculaFuncionario.getSingleResult();

                if (Objects.nonNull(matriculaFuncionario)) {
                    // Depois, exclua as matrículas dos funcionários
                    Query deletaMatriculaFuncionario = entityManager.createNativeQuery("DELETE FROM condominio.tb_matricula_funcionarios WHERE id_funcionario = ?");
                    deletaMatriculaFuncionario.setParameter(1, id);
                    deletaMatriculaFuncionario.executeUpdate();
                    existe = true;
                }
            } catch (NoResultException ex){
                System.out.println("Não existe dados de Matricula Funcionario ID:" + id);
            }

            // Por fim, consulta o próprio funcionário
            Query consultaFuncionario = entityManager.createNativeQuery("SELECT * FROM condominio.tb_funcionarios WHERE id = ?");
            consultaFuncionario.setParameter(1, id);
            try {
                Funcionario funcionario = (Funcionario) consultaFuncionario.getSingleResult();

                if (Objects.nonNull(funcionario)) {
                    // Por fim, exclua o próprio funcionário
                    Query deletaFuncionario = entityManager.createNativeQuery("DELETE FROM condominio.tb_funcionarios WHERE id = ?");
                    deletaFuncionario.setParameter(1, id);
                    deletaFuncionario.executeUpdate();
                    existe = true;
                }
            } catch (NoResultException ex){
                System.out.println("Não existe dados de Funcionario ID:" + id);
            }
        }
    }
}