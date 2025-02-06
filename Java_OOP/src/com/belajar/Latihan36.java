package com.belajar;

class Mobil {
    // Properties
    private String merk;
    private String warna;
    private int tahun;
    
    // Constructor
    public Mobil(String merk, String warna, int tahun) {
        this.merk = merk;
        this.warna = warna;
        this.tahun = tahun;
    }
    
    // Methods
    public void tampilkanInfo() {
        System.out.println("Informasi Mobil:");
        System.out.println("Merk: " + merk);
        System.out.println("Warna: " + warna);
        System.out.println("Tahun: " + tahun);
        System.out.println();
    }
}

public class Latihan36 {
    public static void main(String[] args) {
        // Membuat objek mobil
        Mobil mobil1 = new Mobil("Toyota", "Merah", 2020);
        Mobil mobil2 = new Mobil("Honda", "Hitam", 2021);
        
        // Menampilkan informasi mobil
        mobil1.tampilkanInfo();
        mobil2.tampilkanInfo();
    }
}
