package br.com.email.domain;

import br.com.email.enuns.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_email")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;
    private String idUsuario;
    private String remetente;
    private String destinatario;
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String texto;
    private LocalDate data;
    private LocalTime hora;
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
}
