package br.com.funcionario.model;

import br.com.funcionario.model.enuns.EstadoCivilEnum;
import br.com.funcionario.model.enuns.EstadoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_funcionarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;
    @Column(name = "cpf", length = 255, nullable = false)
    private String cpf;
    @Column(name = "rg", length = 255, nullable = false)
    private String rg;
    @Column(name = "email", length = 255, nullable = false)
    private String email;
    @Column(name = "ddd", length = 255, nullable = false)
    private String ddd;
    @Column(name = "telefone", length = 255, nullable = false)
    private String telefone;
    @Column(name = "situacao", length = 255, nullable = false)
    private EstadoEnum situacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil")
    private EstadoCivilEnum estadoCivil;
    @Column(name = "dependentes")
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<Dependentes> dependentes = new ArrayList<Dependentes>();
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "funcionario", fetch = FetchType.LAZY)
    private Endereco endereco;
}
