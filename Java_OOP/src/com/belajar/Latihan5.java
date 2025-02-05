package com.belajar;
import java.util.Scanner;

public class Latihan5 {
    public static void main(String[] args) {
        // Input Data anggota panti jompo
        int id, lamaMenetap,  usia, teleponWali;
        String nama, gender;
        Scanner Input = new Scanner(System.in);

        // Input Data
        System.out.println("--------------------------------");
        System.out.println("---INPUT PERSERTA PANTI JOMPO---");
        System.out.println("--------------------------------");

        System.out.print("ID Perserta : ");
        id = Input.nextInt();
        Input.nextLine();
        System.out.print("Nama : ");
        nama = Input.nextLine();
        System.out.print("Umur : ");
        usia = Input.nextInt();
        System.out.print("Jenis Kelamin : ");
        gender = Input.next();
        System.out.print("No. Telepon Wali : ");
        teleponWali = Input.nextInt();
        System.out.print("Lama Tinggal : ");
        lamaMenetap = Input.nextInt();

        // Menampilkan data
        System.out.println("--------------------------");
        System.out.println("INPUT PERSERTA PANTI JOMPO");
        System.out.println("--------------------------");

        System.out.println("ID: " + id );
        System.out.println("Nama: " + nama );
        System.out.println("Umur: " + usia );
        System.out.println("Gender: " + gender );
        System.out.println("No Telepon Wali: " + teleponWali );
        System.out.println("Lama Menetap: " + lamaMenetap + " hari" );
    }
}
