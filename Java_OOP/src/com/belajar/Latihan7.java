package com.belajar;

class Kendaraan {
    protected String merk;
    protected int tahun;

    public Kendaraan(String merk, int tahun) {
        this.merk = merk;
        this.tahun = tahun;
    }
}

class mobil extends Kendaraan {
    private int jumlahPintu;

    public mobil(String merk, int tahun, int jumlahPintu) {
        super(merk, tahun);
        this.jumlahPintu = jumlahPintu;
    }

    public void tampilkanInfo() {
        System.out.println("Merk: " + merk);
        System.out.println("Tahun: " + tahun);
        System.out.println("Jumlah Pintu: " + jumlahPintu);
    }
}

public class Latihan7 {
    public static void main(String[] args) {
        mobil mobil1 = new mobil("Toyota", 2020, 4);
        mobil mobil2 = new mobil("Honda", 2021, 2);

        System.out.println("=== Info Mobil 1 ===");
        mobil1.tampilkanInfo();
        
        System.out.println("\n=== Info Mobil 2 ===");
        mobil2.tampilkanInfo();
    }
}
