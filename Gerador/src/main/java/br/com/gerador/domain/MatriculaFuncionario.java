package br.com.gerador.domain;

import br.com.gerador.domain.enuns.EnumAtivo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_matricula_funcionarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class MatriculaFuncionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_identificador", length = 36)
    private UUID uuidIdentificador;
    @Column(name = "numero_funcionario", length = 20)
    private Integer numeroFuncionario;
    @Column(name = "data")
    private LocalDate data;
    @Column(name = "hora")
    private LocalTime hora;
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @Enumerated(EnumType.STRING)
    @Column(name = "ativo", length = 7)
    private EnumAtivo ativo;
}
