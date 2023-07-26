package br.com.funcionario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_enderecos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cep", length = 8)
    private String cep;
    @Column(name = "logradouro", length = 255)
    private String logradouro;
    @Column(name = "numero", length = 10)
    private String numero;
    @Column(name = "bairro", length = 100)
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "uf", length = 15)
    private String uf;
    @Column(name = "pais", length = 161)
    private String pais;
    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
}
