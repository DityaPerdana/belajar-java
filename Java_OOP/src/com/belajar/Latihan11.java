package com.belajar;

import java.util.ArrayList;
import java.util.List;

class Buku {
    private String judul;
    private String penulis;
    private int tahun;

    public Buku(String judul, String penulis, int tahun) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
    }

    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Tahun: " + tahun);
    }
}

class Perpustakaan {
    private List<Buku> daftarBuku;

    public Perpustakaan() {
        daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tampilkanSemuaBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Perpustakaan kosong!");
            return;
        }

        System.out.println("=== Daftar Buku ===");
        for (int i = 0; i < daftarBuku.size(); i++) {
            System.out.println("\nBuku " + (i + 1) + ":");
            daftarBuku.get(i).tampilkanInfo();
        }
    }
}

public class Latihan11 {
    public static void main(String[] args) {
        Perpustakaan perpus = new Perpustakaan();

        perpus.tambahBuku(new Buku("Java Programming", "John Doe", 2020));
        perpus.tambahBuku(new Buku("Python Basics", "Jane Smith", 2019));
        perpus.tambahBuku(new Buku("Web Development", "Bob Johnson", 2021));

        perpus.tampilkanSemuaBuku();
    }
}
