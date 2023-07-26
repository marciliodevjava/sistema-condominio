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
@Table(name = "tb_depedentes")
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
    @Column
    private GrauParentescoEnum grauParentesco;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
}
