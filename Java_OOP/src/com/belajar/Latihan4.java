package com.belajar;
import java.util.Scanner;

public class Latihan4 {

    public static void main(String[] args) {
        // Mengolah input data sederhana
        // menggunakan class Scanner
        int NISN, Usia;
        String Nama, Alamat;
        Scanner Input = new Scanner(System.in);
        System.out.println("DATA SISWA");
        System.out.println("----------");
        System.out.print("NISN : ");
        NISN = Input.nextInt();
        System.out.print("Nama : ");
        Nama = Input.next();
        System.out.print("Alamat : ");
        Alamat = Input.next();
        System.out.print("Usia : ");
        Usia = Input.nextInt();
        
        // Menampilkan data siswa
        System.out.println("DATA SISWA");
        System.out.println("----------");
        System.out.println("NISN: " + NISN);
        System.out.println("Nama: " + Nama);
        System.out.println("Alamat: " + Alamat);
        System.out.println("Usia: " + Usia);

    }
}
