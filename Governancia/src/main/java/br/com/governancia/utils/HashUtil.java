package br.com.governancia.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashUtil {

    public static String getSecureHash(String text) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashSenha = encoder.encode(text);
        return hashSenha;
    }
}
