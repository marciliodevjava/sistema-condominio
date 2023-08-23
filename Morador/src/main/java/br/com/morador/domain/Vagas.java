package br.com.morador.domain;

import br.com.morador.domain.enuns.EnumSetorVaga;
import br.com.morador.domain.enuns.EnumTiposVaga;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_vagas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Vagas implements Serializable {
    @Serial
    private static final long serialVersionUID = 103L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_vagas", length = 100)
    private String uuidVagas;
    private String numero;
    @Column(name = "setor", nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    private EnumSetorVaga setor;
    @Column(name = "tipo", nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    private EnumTiposVaga tipo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_moradorResponsavel")
    private MoradorResponsavel moradorResponsavel;
}
