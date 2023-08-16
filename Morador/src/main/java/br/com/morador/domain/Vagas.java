package br.com.morador.domain;

import br.com.morador.domain.enuns.EnumTiposVaga;
import br.com.morador.domain.enuns.EnunSetorVaga;
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
    private String uuidVagas;
    private String numero;
    private EnunSetorVaga setor;
    private EnumTiposVaga tipo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_apartamento")
    private Apartamentos apartamento;
}