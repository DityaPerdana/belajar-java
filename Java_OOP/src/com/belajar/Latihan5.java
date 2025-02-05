package com.belajar;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

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

    public static void Main(String[] args) throws IOException {
        String nama;
        Integer umur;
        // Membuat objek input stringstream
        InputStreamReader isr = new InputStreamReader(System.in);
        // Membuat objek buffered reader
        BufferedReader br = new BufferedReader(isr);
        // Mengisi variabel nama dengan data yang diinputkan
        System.out.print("Masukkan Nama Anda: ");
        nama = br.readLine();
        System.out.print("Masukkan Umur");
        umur = br.read();
        // Menampilkan pesan Halo, nama!
        System.out.print("Halo, " + nama + "!");
        
    }
}
