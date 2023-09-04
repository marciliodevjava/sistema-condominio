package br.com.email.resource;

import br.com.email.domain.EmailDomain;
import br.com.email.dto.EmailDto;
import br.com.email.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailResource {
    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<EmailDomain> enviarEmail(@RequestBody @Valid EmailDto emailDto) {
        EmailDomain dto = new EmailDomain();
        BeanUtils.copyProperties(emailDto, dto);
        dto = emailService.enviarEmail(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
