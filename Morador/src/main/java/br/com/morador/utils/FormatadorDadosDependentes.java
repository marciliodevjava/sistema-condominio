package br.com.morador.utils;

import br.com.morador.domain.enuns.EnumSexo;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FormatadorDadosDependentes {
    public String formatarNome(String nome) {
        nome = nome.replace(".", "");
        nome = nome.replace("-", "");
        return nome.trim();
    }

    public String formatarCpf(String cpf) {
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        return cpf.trim();
    }

    public String formatarRg(String rg) {
        rg = rg.replace(".", "");
        rg = rg.replace("-", "");
        rg = rg.replace("'\'", "");
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

    public String formatarDddPais(String dddPais) {
        dddPais = dddPais.replace(",", "");
        dddPais = dddPais.replace(".", "");
        return dddPais.toUpperCase().trim();
    }

    public String formatarDdd(String ddd) {
        if (ddd != null && Integer.valueOf(ddd) <= 3) {
            return ddd.toUpperCase().trim();
        }
        return null;
    }

    public String formatarTelefone(String telefone) {
        if (telefone != null && telefone instanceof String) {
            telefone = telefone.replace(".", "");
            telefone = telefone.replace("-", "").trim();
            if (Integer.valueOf(telefone) <= 9) {
                return telefone;
            }
            return "S/N";
        }
        return "N/I";
    }

    public EnumSexo formatarSexo(EnumSexo sexo) {
        if (sexo != null && sexo instanceof EnumSexo) {
            return sexo;
        }
        return EnumSexo.NAO_DEFINIDO;
    }

    public String formatarDateParaString(Date dataNascimento) {
        String dataFormatar = "yyyy-MM-dd";
        SimpleDateFormat formatarData = new SimpleDateFormat(dataFormatar);
        Date data = null;
        try {
            data = formatarData.parse(String.valueOf(dataNascimento));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return String.valueOf(data);
    }
}
