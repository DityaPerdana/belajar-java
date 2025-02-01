package com.belajar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Pertanyaan {
    private String soal;
    private List<String> pilihan;
    private int jawabanBenar;

    public Pertanyaan(String soal, List<String> pilihan, int jawabanBenar) {
        this.soal = soal;
        this.pilihan = pilihan;
        this.jawabanBenar = jawabanBenar;
    }

    public String getSoal() { return soal; }
    public List<String> getPilihan() { return pilihan; }
    public int getJawabanBenar() { return jawabanBenar; }
}

class KategoriKuis {
    private String nama;
    private List<Pertanyaan> pertanyaan;

    public KategoriKuis(String nama) {
        this.nama = nama;
        this.pertanyaan = new ArrayList<>();
    }

    public void tambahPertanyaan(Pertanyaan pertanyaan) {
        this.pertanyaan.add(pertanyaan);
    }

    public String getNama() { return nama; }
    public List<Pertanyaan> getPertanyaan() { return pertanyaan; }
}

class SistemKuis {
    private Map<String, KategoriKuis> kategoriMap;
    private Scanner scanner;
    private int skor;

    public SistemKuis() {
        this.kategoriMap = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.skor = 0;
        inisialisasiKuis();
    }

    private void inisialisasiKuis() {
        // Kategori Sejarah Indonesia
        KategoriKuis sejarah = new KategoriKuis("Sejarah Indonesia");
        
        sejarah.tambahPertanyaan(new Pertanyaan(
            "Siapa proklamator kemerdekaan Indonesia?",
            List.of(
                "Soekarno-Hatta",
                "Soeharto-Habibie",
                "Megawati-Gus Dur",
                "Jokowi-JK"
            ),
            0
        ));

        sejarah.tambahPertanyaan(new Pertanyaan(
            "Kapan Indonesia merdeka?",
            List.of(
                "17 Agustus 1945",
                "17 Agustus 1944",
                "17 Agustus 1946",
                "17 Agustus 1947"
            ),
            0
        ));

        // Kategori Geografi
        KategoriKuis geografi = new KategoriKuis("Geografi");
        
        geografi.tambahPertanyaan(new Pertanyaan(
            "Pulau terbesar di Indonesia adalah...",
            List.of(
                "Kalimantan",
                "Sumatera",
                "Papua",
                "Jawa"
            ),
            0
        ));

        geografi.tambahPertanyaan(new Pertanyaan(
            "Gunung tertinggi di Indonesia adalah...",
            List.of(
                "Puncak Jaya",
                "Semeru",
                "Rinjani",
                "Kerinci"
            ),
            0
        ));

        kategoriMap.put("sejarah", sejarah);
        kategoriMap.put("geografi", geografi);
    }

    public void mulaiKuis() {
        System.out.println("=== Selamat Datang di Sistem Kuis ===\n");
        System.out.println("Kategori yang tersedia:");
        kategoriMap.forEach((key, value) -> 
            System.out.println("- " + value.getNama())
        );

        while (true) {
            System.out.print("\nPilih kategori (atau ketik 'keluar' untuk berhenti): ");
            String pilihan = scanner.nextLine().toLowerCase();

            if (pilihan.equals("keluar")) {
                break;
            }

            KategoriKuis kategori = kategoriMap.get(pilihan);
            if (kategori != null) {
                jalankanKuis(kategori);
            } else {
                System.out.println("Kategori tidak ditemukan!");
            }
        }

        System.out.println("\nTerima kasih telah bermain!");
        System.out.println("Skor akhir Anda: " + skor);
    }

    private void jalankanKuis(KategoriKuis kategori) {
        System.out.println("\n=== Kuis " + kategori.getNama() + " ===\n");
        List<Pertanyaan> pertanyaan = kategori.getPertanyaan();

        for (int i = 0; i < pertanyaan.size(); i++) {
            Pertanyaan p = pertanyaan.get(i);
            System.out.println("Pertanyaan " + (i + 1) + ":");
            System.out.println(p.getSoal());

            List<String> pilihan = p.getPilihan();
            for (int j = 0; j < pilihan.size(); j++) {
                System.out.println((j + 1) + ". " + pilihan.get(j));
            }

            System.out.print("Jawaban Anda (1-" + pilihan.size() + "): ");
            try {
                int jawaban = Integer.parseInt(scanner.nextLine()) - 1;
                if (jawaban == p.getJawabanBenar()) {
                    System.out.println("Benar! +10 poin");
                    skor += 10;
                } else {
                    System.out.println("Salah! Jawaban yang benar: " + 
                        pilihan.get(p.getJawabanBenar()));
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Dianggap salah.");
            }
            System.out.println();
        }

        System.out.println("Skor saat ini: " + skor);
    }
}

public class Latihan27 {
    public static void main(String[] args) {
        SistemKuis kuis = new SistemKuis();
        kuis.mulaiKuis();
    }
}
