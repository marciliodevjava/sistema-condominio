package br.com.funcionario.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FormatadorDeDados {

    public String formatadorCpf(String cpf) {

        cpf = cpf.replace(" ", "");
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");

        return cpf.trim();
    }

    public String formatadorNome(String nomeCompleto) {
        String[] palavras = nomeCompleto.toLowerCase().split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.equals("de") || !palavra.equals("da")) {
                resultado.append(Character.toUpperCase(palavra.charAt(0))).append(palavra.substring(1)).append(" ");
            } else {
                resultado.append(palavra).append(" ");
            }
        }
        return resultado.toString().trim();
    }

    public String formatadorRg(String rg) {
        rg = rg.replace(" ", "");
        rg = rg.replace(".", "");
        rg = rg.replace("-", "");
        return rg.trim();
    }

    public String formatadorEmail(String email) {
        email = email.replace(" ", "");
        email = email.toLowerCase();
        return email.trim();
    }

    public String formatadorTelefone(String telefone) {
        telefone = telefone.replace("", "");
        telefone = telefone.replace("-", "");
        return telefone.trim();
    }

    public Date formatadorDataString(String dataNascimento) throws ParseException {
        String dataFormatar = "yyyy-MM-dd";
        SimpleDateFormat formatarData = new SimpleDateFormat(dataFormatar);
        Date data = formatarData.parse(dataNascimento);

        return data;
    }

    public String formatadorDataDate(Date dataNascimento) throws ParseException {
        String dataFormatar = "yyyy-MM-dd";
        SimpleDateFormat formatarData = new SimpleDateFormat(dataFormatar);
        String dataFormatada = formatarData.format(dataNascimento);

        return dataFormatada;
    }

    public String formatadorCepEndereco(String cep) {
        cep = cep.replace("-", "");
        return cep.trim();
    }

    public String formatadorLogradouroEndereco(String logradouro) {
        logradouro = logradouro.replace("  ", " ");
        logradouro = logradouro.replace(",", "");
        logradouro = logradouro.replace(".", "");
        logradouro = logradouro.replace("-", "");

        String[] palavras = logradouro.toLowerCase().split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            resultado.append(Character.toUpperCase(palavra.charAt(0))).append(palavra.substring(1)).append(" ");
        }
        return resultado.toString().trim();
    }

    public String formatadorNumeroEndereco(String numero) {
        try {
            Integer.parseInt(numero);
            return String.valueOf(numero);
        } catch (NumberFormatException e) {
            return String.valueOf("S/N");
        }
    }

    public String formatadorBairroEndereco(String bairro) {
        String[] palavras = bairro.toLowerCase().split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            resultado.append(Character.toUpperCase(palavra.charAt(0))).append(palavra.substring(1)).append(" ");
        }
        return resultado.toString().trim();
    }

    public String formatadorCidadeEndereco(String cidade) {
        String primeiraLetra = cidade.substring(0,1).toUpperCase();
        String restantePalavra = cidade.substring(1).toLowerCase();
        String retorno = primeiraLetra + restantePalavra;

        return retorno.trim();
    }

    public String formatadorUfEndereco(String uf) {
        return uf.trim().toUpperCase();
    }

    public String formatadorPaisEndereco(String pais) {
        String primeiraLetra = pais.substring(0,1).toUpperCase();
        String restantePalavra = pais.substring(1).toLowerCase();
        String retorno = primeiraLetra + restantePalavra;

        return retorno.trim();
    }
}
