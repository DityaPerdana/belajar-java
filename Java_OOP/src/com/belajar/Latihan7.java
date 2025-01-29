package com.belajar;

class Kendaraan {
    protected String merk;
    protected int tahun;

    public Kendaraan(String merk, int tahun) {
        this.merk = merk;
        this.tahun = tahun;
    }
}

class Mobil extends Kendaraan {
    private int jumlahPintu;

    public Mobil(String merk, int tahun, int jumlahPintu) {
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
        Mobil mobil1 = new Mobil("Toyota", 2020, 4);
        Mobil mobil2 = new Mobil("Honda", 2021, 2);

        System.out.println("=== Info Mobil 1 ===");
        mobil1.tampilkanInfo();
        
        System.out.println("\n=== Info Mobil 2 ===");
        mobil2.tampilkanInfo();
    }
}
