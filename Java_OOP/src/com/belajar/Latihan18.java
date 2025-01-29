package com.belajar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ValidatorData {
    public static boolean validasiEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validasiNomorHP(String nomorHP) {
        String regex = "^(\\+62|62|0)\\d{9,12}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nomorHP);
        return matcher.matches();
    }

    public static boolean validasiPassword(String password) {
        // Minimal 8 karakter, harus mengandung huruf besar, huruf kecil, dan angka
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

public class Latihan18 {
    public static void main(String[] args) {
        System.out.println("=== Program Validasi Data ===\n");

        // Test validasi email
        System.out.println("Validasi Email:");
        System.out.println("user@example.com -> " + 
            ValidatorData.validasiEmail("user@example.com"));
        System.out.println("invalid.email -> " + 
            ValidatorData.validasiEmail("invalid.email"));
        
        System.out.println("\nValidasi Nomor HP:");
        System.out.println("081234567890 -> " + 
            ValidatorData.validasiNomorHP("081234567890"));
        System.out.println("+6281234567890 -> " + 
            ValidatorData.validasiNomorHP("+6281234567890"));
        System.out.println("12345 -> " + 
            ValidatorData.validasiNomorHP("12345"));

        System.out.println("\nValidasi Password:");
        System.out.println("Password123 -> " + 
            ValidatorData.validasiPassword("Password123"));
        System.out.println("weakpass -> " + 
            ValidatorData.validasiPassword("weakpass"));
        System.out.println("NoNumber -> " + 
            ValidatorData.validasiPassword("NoNumber"));
    }
}
