package com.belajar;
// Latihan method static
public class MobilAna {
    // variabel static
    static String warna = "putih";
    static int tahunProduksi = 1444;
    // method static
    static void penghitaman(){
        warna ="HITAM LEGAM";
    }
    static void display(){
        System.out.println("nama : Sukhoi");
        System.out.println("Warna: " + warna);
        System.out.println("Tahun Produksi: " + tahunProduksi + " Hijriah");
    }

    public static void main(String[] args) {
        MobilAna.display();
        MobilAna sukhoi = new MobilAna();
        sukhoi.penghitaman();
        sukhoi.display();
    }
}
