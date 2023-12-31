package br.com.governancia.utils;

import br.com.governancia.repository.UuidRepository;
import br.com.governancia.usuario.Uuid;
import br.com.governancia.usuario.enuns.EnumProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Component
public class GeradorUuid {

    @Autowired
    private UuidRepository uuidRepository;

    public String getIdentificadorUuid() {
        UUID identificador;
        Uuid uuid;
        String uuidGerado;

        do {
            identificador = UUID.randomUUID();
            uuid = uuidRepository.findByUuidGerado(String.valueOf(identificador));
        } while (uuid != null);

        uuidGerado = String.valueOf(String.valueOf(identificador));

        Uuid salvar = new Uuid();

        salvar.setUuidGerado(String.valueOf(identificador));
        salvar.setData(LocalDate.now());
        salvar.setHora(LocalTime.now());
        salvar.setProjeto(EnumProjeto.GOVERNANCIA);

        salvar = uuidRepository.save(salvar);

        return uuidGerado.toString();
    }
}
