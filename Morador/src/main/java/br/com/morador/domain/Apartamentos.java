package br.com.morador.domain;

import br.com.morador.domain.enuns.EnumAndar;
import br.com.morador.domain.enuns.EnumBloco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_apartamentos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Apartamentos implements Serializable {
    @Serial
    private static final long serialVersionUID= 10L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_apartamento", length = 100, nullable = false)
    private String uuidApartamento;
    @Column(name = "numero", length = 5, nullable = false)
    private Integer numero;
    @Column(name = "bloco", length = 7, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumBloco bloco;
    @Column(name = "andar", length = 7, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumAndar andar;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apartamento", fetch = FetchType.LAZY)
    private MoradorResponsavel morador;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apartamento", fetch = FetchType.LAZY)
    private List<Vagas> vagas = new ArrayList<>();
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_proprietario", nullable = false)
    private Proprietario proprietario;
}
