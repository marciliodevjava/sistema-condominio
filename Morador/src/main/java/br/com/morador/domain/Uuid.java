package br.com.morador.domain;

import br.com.morador.domain.enuns.EnumProjeto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "tb_uuid")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Uuid implements Serializable {

    @Serial
    private static final long serialVersionUID = 104L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_gerador")
    private String uuidGerado;
    @Column(name = "data")
    private Date data;
    @Column(name = "hora")
    private LocalTime hora;
    @Enumerated(EnumType.STRING)
    @Column(name = "projeto")
    private EnumProjeto projeto;
}
