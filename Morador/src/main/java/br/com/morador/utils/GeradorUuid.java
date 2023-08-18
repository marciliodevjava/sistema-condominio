package br.com.morador.utils;

import br.com.morador.domain.Uuid;
import br.com.morador.domain.enuns.EnumProjeto;
import br.com.morador.repository.UuidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Component
public class GeradorUuid {
    @Autowired
    private UuidRepository uuidRepository;

    public String gerarUuid() {
        Uuid uuidClass = new Uuid();
        String gerado;
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
            gerado = String.valueOf(uuid);
            uuidClass = uuidRepository.findByUuidGerado(gerado);
        } while (uuidClass != null);

        uuidClass.setUuidGerado(gerado);
        uuidClass.setProjeto(EnumProjeto.MORADOR);
        uuidClass.setData(new Date());
        uuidClass.setHora(LocalTime.now());

        uuidClass = uuidRepository.save(uuidClass);

        return uuidClass.getUuidGerado();
    }
}
