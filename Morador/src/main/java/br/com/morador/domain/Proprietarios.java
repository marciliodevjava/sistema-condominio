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
@Table(name = "tb_proprietario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Proprietarios implements Serializable {
    @Serial
    private static final long serialVersionUID= 8L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_proprietario", length = 100, nullable = false)
    private String uuidProprietario;
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;
    @Column(name = "cpf", unique = true, length = 11, nullable = false)
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String ddd;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proprietario", fetch = FetchType.LAZY)
    private List<Apartamentos> apartamento = new ArrayList<>();
}
