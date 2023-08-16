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
    private static final long serialVersionUID= 11L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuidDependenteMorador;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String email;
    private String ddd;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_apartamento")
    private MoradorResponsavel responsavel;
}
