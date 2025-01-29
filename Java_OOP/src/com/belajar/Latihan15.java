package com.belajar;

import java.util.HashMap;
import java.util.Map;

class KamusIndonesiaInggris {
    private Map<String, String> kamus;

    public KamusIndonesiaInggris() {
        kamus = new HashMap<>();
        initKamus();
    }

    private void initKamus() {
        kamus.put("kucing", "cat");
        kamus.put("anjing", "dog");
        kamus.put("burung", "bird");
        kamus.put("ikan", "fish");
        kamus.put("kuda", "horse");
    }

    public void tambahKata(String indonesia, String inggris) {
        kamus.put(indonesia.toLowerCase(), inggris.toLowerCase());
        System.out.println("Kata berhasil ditambahkan!");
    }

    public String terjemahkan(String kata) {
        String terjemahan = kamus.get(kata.toLowerCase());
        if (terjemahan == null) {
            return "Kata '" + kata + "' tidak ditemukan dalam kamus";
        }
        return terjemahan;
    }

    public void tampilkanSemuaKata() {
        System.out.println("\nDaftar Kata dalam Kamus:");
        System.out.println("-------------------------");
        for (Map.Entry<String, String> entry : kamus.entrySet()) {
            System.out.printf("%-10s : %s\n", entry.getKey(), entry.getValue());
        }
    }
}

public class Latihan15 {
    public static void main(String[] args) {
        System.out.println("=== Kamus Indonesia-Inggris ===");
        
        KamusIndonesiaInggris kamus = new KamusIndonesiaInggris();
        
        // Menampilkan semua kata
        kamus.tampilkanSemuaKata();

        // Menerjemahkan beberapa kata
        System.out.println("\nHasil Terjemahan:");
        System.out.println("------------------");
        System.out.println("kucing -> " + kamus.terjemahkan("kucing"));
        System.out.println("ANJING -> " + kamus.terjemahkan("ANJING")); // Test case insensitive
        System.out.println("gajah -> " + kamus.terjemahkan("gajah")); // Kata yang tidak ada

        // Menambah kata baru
        System.out.println("\nMenambah kata baru:");
        kamus.tambahKata("gajah", "elephant");
        kamus.tambahKata("singa", "lion");

        // Menampilkan kamus setelah penambahan
        kamus.tampilkanSemuaKata();
    }
}
