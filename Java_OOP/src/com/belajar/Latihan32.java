package com.belajar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Latihan32 {
    public static void main(String[] args) throws IOException {
        //inisialisasi variabel
        String nama;
        Integer umur;
        Integer nilai;

        // Membuat objek input stringstream
        InputStreamReader isr = new InputStreamReader(System.in);
        // Membuat objek buffered reader

        BufferedReader br = new BufferedReader(isr);

        // Mengisi variabel nama dengan data yang diinputkan
        System.out.print("Masukkan Nama Anda : ");
        nama = br.readLine();
        System.out.print("Masukkan Umur : ");
        umur = Integer.parseInt(br.readLine());
        System.out.print("Masukkan Nilai Anda : ");
        nilai = Integer.parseInt(br.readLine());

        // Menampilkan pesan
        System.out.println("Halo, " + nama + "!");
        System.out.println("Umur Anda: " + umur);
        if(nilai < 75){
            System.out.println("skill issue, nila kamu " + nilai + " harus belajar lebih giat lagi");
        } else {
            System.out.println("selamat! Nilai kamu " + nilai + " belajar lagi");
        }
    }
        // /\_/\
       // ( o.o )
        // > ^ <
        // Meoww
}
