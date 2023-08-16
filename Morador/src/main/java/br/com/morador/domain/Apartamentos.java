package br.com.morador.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_morador")
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
    private String uuidApartamento;
    private Integer numero;
    private String bloco;
    private String andar;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apartamento", fetch = FetchType.LAZY)
    private MoradorResponsavel morador;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_proprietario")
    private Proprietarios proprietario;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apartamento", fetch = FetchType.LAZY)
    private List<Vagas> vagas = new ArrayList<>();
}
