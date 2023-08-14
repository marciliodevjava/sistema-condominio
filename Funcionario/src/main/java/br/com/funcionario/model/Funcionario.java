package br.com.funcionario.model;

import br.com.funcionario.model.enuns.EstadoCivilEnum;
import br.com.funcionario.model.enuns.EstadoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_funcionarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_identificador", length = 36)
    private String uuidIdentificador;
    @Column(name = "numero_funcionario", length = 20)
    private Integer numeroFuncionario;
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;
    @Column(name = "rg", length = 10, nullable = false)
    private String rg;
    @Column(name = "email", length = 150, nullable = false)
    private String email;
    @Column(name = "ddd", length = 3, nullable = false)
    private String ddd;
    @Column(name = "telefone", length = 10, nullable = false)
    private String telefone;
    @Enumerated(EnumType.STRING)
    @Column(name = "situacao", length = 9, nullable = false)
    private EstadoEnum situacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil", length = 10, nullable = false)
    private EstadoCivilEnum estadoCivil;
    @Column(name = "dependentes")
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<Dependentes> dependentes = new ArrayList<Dependentes>();
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<Endereco> endereco = new ArrayList<>();
}
