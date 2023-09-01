package br.com.email.service;

import br.com.email.domain.EmailDomain;
import br.com.email.enuns.StatusEmail;
import br.com.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private JavaMailSender emailSender;

    public EmailDomain enviarEmail(EmailDomain dto) {
        dto.setData(LocalDate.now());
        dto.setHora(LocalTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(dto.getRemetente());
            message.setTo(dto.getDestinatario());
            message.setSubject(dto.getTitulo());
            message.setText(dto.getTexto());
            emailSender.send(message);

            dto.setStatusEmail(StatusEmail.ENVIADO);
        } catch (MailException ex) {
            dto.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(dto);
        }
    }
}
