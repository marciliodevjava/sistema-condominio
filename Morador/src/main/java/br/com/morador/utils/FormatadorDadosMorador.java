package br.com.morador.utils;

import br.com.morador.domain.enuns.EnumSexo;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FormatadorDadosMorador {
    public String formatadorNome(String nome) {
        nome = nome.replace(".", "");
        nome = nome.replace("-", "");
        return nome.trim();
    }

    public String formatadorCpf(String cpf) {
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        return cpf.trim();
    }

    public String formatadorRg(String rg) {
        rg = rg.replace(".", "");
        rg = rg.replace("-", "");
        rg = rg.replace("'\'", "");
        return rg.trim();
    }

    public Date formatadorStringParaDate(String dataNascimento) {
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

    public String formatadorDddPais(String dddPais) {
        dddPais = dddPais.replace(",", "");
        dddPais = dddPais.replace(".", "");
        return dddPais.toUpperCase().trim();
    }

    public String formatadorDdd(String ddd) {
        if (ddd != null && ddd.length() <= 3) {
            return ddd;
        }
        return "S/N";
    }

    public String formatadorTelefone(String telefone) {
        if (telefone != null && telefone instanceof String) {
            telefone = telefone.replace(".", "");
            telefone = telefone.replace("-", "").trim();
            if (telefone.length() <= 9) {
                return telefone;
            }
            return "S/N";
        }
        return "N/I";
    }

    public EnumSexo formatadorSexo(EnumSexo sexo) {
        if (sexo != null && sexo instanceof EnumSexo) {
            return sexo;
        }
        return EnumSexo.NAO_DEFINIDO;
    }

    public String formatadorDateParaString(Date dataNascimento) {
        String dataFormatar = "yyyy-MM-dd";
        SimpleDateFormat formatarData = new SimpleDateFormat(dataFormatar);
        String dataFormatada = formatarData.format(dataNascimento);

        return dataFormatada;
    }
}
