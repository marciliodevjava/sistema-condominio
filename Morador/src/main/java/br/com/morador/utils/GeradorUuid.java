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

        Uuid uuidRetorno = new Uuid();

        uuidRetorno.setUuidGerado(gerado);
        uuidRetorno.setProjeto(EnumProjeto.MORADOR);
        uuidRetorno.setData(new Date());
        uuidRetorno.setHora(LocalTime.now());

        uuidRetorno = uuidRepository.save(uuidRetorno);

        return uuidRetorno.getUuidGerado().toString();
    }
}
