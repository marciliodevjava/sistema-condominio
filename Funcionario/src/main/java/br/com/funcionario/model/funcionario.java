package br.com.funcionario.model;

import br.com.funcionario.model.enuns.EstadoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "tb_funcionario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private String ddd;
    private String telefone;
    private EstadoEnum situacao;
}
