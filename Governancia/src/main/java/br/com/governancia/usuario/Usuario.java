package br.com.governancia.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;
    @Column(name = "login_usuario", length = 50, nullable = false, unique = true)
    private String login;
    @Column(name = "senha_usuario", length = 50, nullable = false)
    private String senha;
    @Column(name = "uuid_identificador", nullable = false)
    private String uuidIdentificador;
    @Column(name = "data", nullable = false)
    private Date data;
    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
