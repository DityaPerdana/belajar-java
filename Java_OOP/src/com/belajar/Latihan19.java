package com.belajar;

import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {
    private double memory;

    public Calculator() {
        this.memory = 0;
    }

    public double add(double a, double b) {
        memory = a + b;
        return memory;
    }

    public double subtract(double a, double b) {
        memory = a - b;
        return memory;
    }

    public double multiply(double a, double b) {
        memory = a * b;
        return memory;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Pembagian dengan nol tidak diperbolehkan!");
        }
        memory = a / b;
        return memory;
    }

    public double getMemory() {
        return memory;
    }

    public void clearMemory() {
        memory = 0;
    }
}

public class Latihan19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        boolean lanjut = true;

        System.out.println("=== Kalkulator Sederhana ===");

        while (lanjut) {
            System.out.println("\nOperasi:");
            System.out.println("1. Penjumlahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");
            System.out.println("5. Lihat Memory");
            System.out.println("6. Clear Memory");
            System.out.println("7. Keluar");
            
            try {
                System.out.print("\nPilih operasi (1-7): ");
                int pilihan = scanner.nextInt();

                if (pilihan == 7) {
                    lanjut = false;
                    continue;
                }

                if (pilihan == 5) {
                    System.out.println("Nilai dalam memory: " + calc.getMemory());
                    continue;
                }

                if (pilihan == 6) {
                    calc.clearMemory();
                    System.out.println("Memory telah dikosongkan!");
                    continue;
                }

                System.out.print("Masukkan angka pertama: ");
                double a = scanner.nextDouble();
                System.out.print("Masukkan angka kedua: ");
                double b = scanner.nextDouble();

                switch (pilihan) {
                    case 1:
                        System.out.printf("Hasil: %.2f\n", calc.add(a, b));
                        break;
                    case 2:
                        System.out.printf("Hasil: %.2f\n", calc.subtract(a, b));
                        break;
                    case 3:
                        System.out.printf("Hasil: %.2f\n", calc.multiply(a, b));
                        break;
                    case 4:
                        try {
                            System.out.printf("Hasil: %.2f\n", calc.divide(a, b));
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Masukan tidak valid!");
                scanner.nextLine(); // Clear scanner buffer
            }
        }

        System.out.println("\nTerima kasih telah menggunakan kalkulator ini!");
        scanner.close();
    }
}
