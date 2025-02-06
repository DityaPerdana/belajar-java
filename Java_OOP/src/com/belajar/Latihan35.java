package com.belajar;

public class Latihan35 {
    public static void main(String[] args) {
        // Memanggil method dengan parameter
        hitungLuas(5, 3);
        hitungLuas(7, 4);
        
        // Menggunakan return value
        int hasil = tambah(10, 5);
        System.out.println("\nHasil penambahan: " + hasil);
    }
    
    // Method untuk menghitung luas persegi panjang
    public static void hitungLuas(int panjang, int lebar) {
        int luas = panjang * lebar;
        System.out.println("Luas persegi panjang dengan:");
        System.out.println("Panjang: " + panjang);
        System.out.println("Lebar: " + lebar);
        System.out.println("Luas: " + luas);
        System.out.println();
    }
    
    // Method dengan return value
    public static int tambah(int a, int b) {
        return a + b;
    }
}
