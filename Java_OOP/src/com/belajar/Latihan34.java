package com.belajar;

public class Latihan34 {
    public static void main(String[] args) {
        // Membuat array
        int[] numbers = {1, 2, 3, 4, 5};
        
        // Menampilkan semua elemen array
        System.out.println("Elemen array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }
        
        // Menghitung jumlah semua elemen
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("\nJumlah semua elemen: " + sum);
        
        // Mencari nilai rata-rata
        double average = (double) sum / numbers.length;
        System.out.println("Rata-rata: " + average);
    }
}
