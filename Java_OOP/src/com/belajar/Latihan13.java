package com.belajar;

class PenangananError {
    public static double bagi(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Pembagian dengan nol tidak diperbolehkan!");
        }
        return a / b;
    }

    public static void validasiUsia(int usia) throws IllegalArgumentException {
        if (usia < 0) {
            throw new IllegalArgumentException("Usia tidak boleh negatif!");
        }
        if (usia > 150) {
            throw new IllegalArgumentException("Usia tidak valid!");
        }
        System.out.println("Usia valid: " + usia + " tahun");
    }
}

public class Latihan13 {
    public static void main(String[] args) {
        System.out.println("=== Program Penanganan Error ===\n");

        // Test pembagian
        try {
            System.out.println("Hasil 10 / 2 = " + PenangananError.bagi(10, 2));
            System.out.println("Hasil 10 / 0 = " + PenangananError.bagi(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        // Test validasi usia
        try {
            PenangananError.validasiUsia(25);
            PenangananError.validasiUsia(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            PenangananError.validasiUsia(200);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
