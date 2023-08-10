package br.com.funcionario.model;

import br.com.funcionario.model.enuns.GrauParentescoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_dependentes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dependentes implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_identificador", length = 36)
    private String uuidIdentificador;
    @Enumerated(EnumType.STRING)
    @Column(name = "grau_parentesco", length = 13)
    private GrauParentescoEnum grauParentesco;
    @Column(name = "nome", length = 150)
    private String nome;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "rg", length = 11)
    private String rg;
    @Column(name = "ddd", length = 3, nullable = false)
    private String ddd;
    @Column(name = "telefone", length = 10)
    private String telefone;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependentes that = (Dependentes) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
