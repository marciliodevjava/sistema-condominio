package br.com.funcionario.model;

import br.com.funcionario.model.enuns.GrauParentescoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_dependentes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dependentes implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "grau_parentesco", length = 13)
    private GrauParentescoEnum grauParentesco;
    @Column(name = "nome", length = 150)
    private String nome;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "rg", length = 11)
    private String rg;
    @Column(name = "ddd", length = 3, nullable = false)
    private String ddd;
    @Column(name = "telefone", length = 10)
    private String telefone;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
}
