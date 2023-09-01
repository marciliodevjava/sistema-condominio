package br.com.email.repository;

import br.com.email.domain.EmailDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailDomain, Long> {
}
