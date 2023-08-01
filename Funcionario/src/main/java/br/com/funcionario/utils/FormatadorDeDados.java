package br.com.funcionario.utils;

import org.springframework.stereotype.Component;

@Component
public class FormatadorDeDados {

    public String formatadorCpf(String cpf){

        cpf = cpf.replace(" ","");
        cpf = cpf.replace(".","");
        cpf = cpf.replace("-","");

        return cpf.trim();
    }

    public String formatadorNome(String nome) {
        nome = nome.replace(" ","");
        return nome.trim();
    }

    public String formatadorRg(String rg) {
        rg = rg.replace(" ","");
        rg = rg.replace(".","");
        rg = rg.replace("-","");
        return rg.trim();
    }

    public String formatadorEmail(String email) {
        email = email.replace(" ","");
        email = email.toLowerCase();
        return email.trim();
    }

    public String formatadorTelefone(String telefone) {
        telefone = telefone.replace("","");
        telefone = telefone.replace("-","");
        return telefone.trim();
    }
}
