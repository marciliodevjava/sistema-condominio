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
    private String uuidMorador;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String email;
    private String ddd;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "morador", fetch = FetchType.LAZY)
    private List<DependentesMorador> dependentes = new ArrayList<>();
    @OneToOne(optional = false)
    @JoinColumn(name = "id_apartamento")
    private Apartamentos apartamento;
}
