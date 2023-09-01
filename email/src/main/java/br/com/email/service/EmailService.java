package br.com.email.service;

import br.com.email.domain.EmailDomain;
import br.com.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    public void enviarEmail(EmailDomain dto) {

    }
}
