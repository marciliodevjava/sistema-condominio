package br.com.morador.domain;

import br.com.morador.domain.enuns.EnumSexo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_dependentes_morador")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DependentesMorador implements Serializable {
    @Serial
    private static final long serialVersionUID= 105L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_dependente", length = 100, nullable = false)
    private String uuidDependenteMorador;
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;
    @Column(name = "cpf", unique = true, length = 11, nullable = false)
    private String cpf;
    @Column(name = "rg", length = 10)
    private String rg;
    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;
    @Column(name = "ddd_pais")
    private String dddPais;
    @Column(name = "ddd", length = 3)
    private String ddd;
    @Column(name = "telefone", length = 9)
    private String telefone;
    @Column(name = "sexo", nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_moradorResponsavel")
    private MoradorResponsavel moradorResponsavel;
}
