package br.com.gerador.domain;

import br.com.gerador.domain.enuns.EnumProjeto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_uuid")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Uuid implements Serializable {

    @Serial
    private static final long serialVersionUID = 5L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_gerador")
    private String uuidGerado;
    @Column(name = "data")
    private LocalDate data;
    @Column(name = "hora")
    private LocalTime hora;
    @Enumerated(EnumType.STRING)
    @Column(name = "projeto")
    private EnumProjeto projeto;
}
