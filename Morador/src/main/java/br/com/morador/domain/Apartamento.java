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
@Table(name = "tb_apartamento")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Apartamento implements Serializable {

    @Serial
    private static final long serialVersionUID= 101L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_apartamento", length = 100)
    private String uuidApartamento;
    @Column(name = "numero", length = 5)
    private Integer numero;
    @Column(name = "bloco", length = 7)
    @Enumerated(EnumType.STRING)
    private EnumBloco bloco;
    @Column(name = "andar", length = 7)
    @Enumerated(EnumType.STRING)
    private EnumAndar andar;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(mappedBy = "apartamento", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private MoradorResponsavel morador;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_proprietario")
    private Proprietario proprietario;
}
