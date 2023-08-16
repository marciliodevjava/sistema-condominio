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
    private static final long serialVersionUID= 12L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_vagas", length = 100, nullable = false)
    private String uuidVagas;
    private String numero;
    private EnumSetorVaga setor;
    private EnumTiposVaga tipo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_apartamento")
    private Apartamentos apartamento;
}
