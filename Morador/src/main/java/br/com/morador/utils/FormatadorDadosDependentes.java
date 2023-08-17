package br.com.morador.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FormatadorDadosDependentes {
    public String formatarNome(String nome) {
        nome = nome.replace(".","");
        nome = nome.replace("-","");        
        return nome.trim();
    }

    public String formatarCpf(String cpf) {
        cpf = cpf.replace(".","");
        cpf = cpf.replace("-","");
        return cpf.trim();
    }

    public String formatarRg(String rg) {
        rg = rg.replace(".","");
        rg = rg.replace("-","");
        rg = rg.replace("'\'","");
        return rg.trim();
    }

    public Date formatarStringParaDate(String dataNascimento) {
        String dataFormatar = "yyyy-MM-dd";
        SimpleDateFormat formatarData = new SimpleDateFormat(dataFormatar);
        Date data = null;
        try {
            data = formatarData.parse(dataNascimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}
