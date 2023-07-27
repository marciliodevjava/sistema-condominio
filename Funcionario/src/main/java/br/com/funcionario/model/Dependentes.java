package br.com.funcionario.model;

import br.com.funcionario.model.enuns.GrauParentescoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_dependentes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Dependentes implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_identificador", length = 36)
    private UUID uuidIdentificador;
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
}
