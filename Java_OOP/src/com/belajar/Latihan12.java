package com.belajar;

enum JenisKelamin {
    LAKI_LAKI("Laki-laki"),
    PEREMPUAN("Perempuan");

    private String deskripsi;

    JenisKelamin(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}

class Karyawan {
    private String nama;
    private JenisKelamin jenisKelamin;
    private double gaji;

    public Karyawan(String nama, JenisKelamin jenisKelamin, double gaji) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.gaji = gaji;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin.getDeskripsi());
        System.out.printf("Gaji: Rp%.2f\n", gaji);
    }
}

public class Latihan12 {
    public static void main(String[] args) {
        Karyawan karyawan1 = new Karyawan("Budi", JenisKelamin.LAKI_LAKI, 5000000);
        Karyawan karyawan2 = new Karyawan("Siti", JenisKelamin.PEREMPUAN, 6000000);

        System.out.println("=== Data Karyawan ===\n");
        System.out.println("Karyawan 1:");
        karyawan1.tampilkanInfo();
        
        System.out.println("\nKaryawan 2:");
        karyawan2.tampilkanInfo();
    }
}
