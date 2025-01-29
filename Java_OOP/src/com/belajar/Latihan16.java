package com.belajar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Siswa implements Comparable<Siswa> {
    private String nama;
    private double nilai;

    public Siswa(String nama, double nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public double getNilai() {
        return nilai;
    }

    @Override
    public int compareTo(Siswa other) {
        return Double.compare(other.nilai, this.nilai); // Descending order
    }

    @Override
    public String toString() {
        return String.format("%-20s : %.2f", nama, nilai);
    }
}

class KelolaNilai {
    private List<Siswa> daftarSiswa;

    public KelolaNilai() {
        daftarSiswa = new ArrayList<>();
    }

    public void tambahSiswa(String nama, double nilai) {
        daftarSiswa.add(new Siswa(nama, nilai));
    }

    public void tampilkanRanking() {
        Collections.sort(daftarSiswa);
        System.out.println("\nDaftar Ranking Siswa:");
        System.out.println("---------------------");
        for (int i = 0; i < daftarSiswa.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), daftarSiswa.get(i));
        }
    }

    public double hitungRataRata() {
        if (daftarSiswa.isEmpty()) return 0;
        double total = 0;
        for (Siswa siswa : daftarSiswa) {
            total += siswa.getNilai();
        }
        return total / daftarSiswa.size();
    }
}

public class Latihan16 {
    public static void main(String[] args) {
        System.out.println("=== Program Kelola Nilai Siswa ===");
        
        KelolaNilai kelola = new KelolaNilai();
        
        // Menambah data siswa
        kelola.tambahSiswa("Budi Santoso", 85.5);
        kelola.tambahSiswa("Ani Wijaya", 90.0);
        kelola.tambahSiswa("Citra Dewi", 88.5);
        kelola.tambahSiswa("Doni Kusuma", 92.5);
        kelola.tambahSiswa("Eva Sari", 87.0);

        // Menampilkan ranking
        kelola.tampilkanRanking();

        // Menampilkan rata-rata
        System.out.printf("\nRata-rata nilai kelas: %.2f\n", kelola.hitungRataRata());
    }
}
