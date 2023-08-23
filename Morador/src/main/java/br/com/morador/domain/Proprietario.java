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
public class Proprietario implements Serializable {
    @Serial
    private static final long serialVersionUID = 100L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_proprietario", length = 100)
    private String uuidProprietario;
    @Column(name = "nome", length = 150)
    private String nome;
    @Column(name = "cpf", unique = true, length = 11)
    private String cpf;
    @Column(name = "rg", length = 10)
    private String rg;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "ddd_pais")
    private String dddPais;
    @Column(name = "ddd", length = 3)
    private String ddd;
    @Column(name = "telefone", length = 9)
    private String telefone;
    @Column(name = "sexo", length = 12)
    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Apartamento> apartamento = new ArrayList<>();

    public Proprietario(Proprietario proprietario) {
        this.uuidProprietario = proprietario.getUuidProprietario();
        this.nome = proprietario.getNome();
        this.cpf = proprietario.getCpf();
        this.rg = proprietario.getRg();
        this.dataNascimento = proprietario.getDataNascimento();
        this.dddPais = proprietario.getDddPais();
        this.ddd = proprietario.getDdd();
        this.telefone = proprietario.getTelefone();
        this.sexo = proprietario.getSexo();
    }
}
