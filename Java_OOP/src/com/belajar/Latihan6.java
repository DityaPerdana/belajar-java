package com.belajar;

class Mahasiswa {
    private String nama;
    private String nim;
    private double ipk;

    public Mahasiswa(String nama, String nim, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.ipk = ipk;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("IPK: " + ipk);
    }
}

public class Latihan6 {
    public static void main(String[] args) {
        // Membuat objek mahasiswa
        Mahasiswa mhs1 = new Mahasiswa("Budi Santoso", "12345", 3.75);
        Mahasiswa mhs2 = new Mahasiswa("Ani Wijaya", "12346", 3.85);

        System.out.println("=== Data Mahasiswa ===");
        System.out.println("Mahasiswa 1:");
        mhs1.tampilkanInfo();
        
        System.out.println("\nMahasiswa 2:");
        mhs2.tampilkanInfo();
    }
}
