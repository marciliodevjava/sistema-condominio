package br.com.morador.domain;

import br.com.morador.domain.enuns.EnumSexo;
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
@Table(name = "tb_morador_responsavel")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class MoradorResponsavel implements Serializable {
    @Serial
    private static final long serialVersionUID= 9L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_morador", length = 100, nullable = false)
    private String uuidMorador;
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;
    @Column(name = "cpf", unique = true, length = 11, nullable = false)
    private String cpf;
    @Column(name = "rg", length = 10)
    private String rg;
    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;
    @Column(name = "ddd_pais", nullable = false)
    private String dddPais;
    @Column(name = "ddd", nullable = false, length = 3)
    private String ddd;
    @Column(name = "telefone", nullable = false, length = 9)
    private String telefone;
    @Column(name = "sexo", nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "morador", fetch = FetchType.LAZY)
    private List<DependentesMorador> dependentes = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "id_apartamento")
    private Apartamentos apartamento;
}
