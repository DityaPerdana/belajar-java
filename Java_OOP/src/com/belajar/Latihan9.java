package com.belajar;

abstract class Bentuk {
    abstract double hitungLuas();
    abstract double hitungKeliling();
}

class Lingkaran extends Bentuk {
    private double jariJari;
    private final double PI = 3.14;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    double hitungLuas() {
        return PI * jariJari * jariJari;
    }

    @Override
    double hitungKeliling() {
        return 2 * PI * jariJari;
    }
}

public class Latihan9 {
    public static void main(String[] args) {
        Lingkaran lingkaran = new Lingkaran(7);
        
        System.out.println("=== Perhitungan Lingkaran ===");
        System.out.printf("Luas Lingkaran: %.2f\n", lingkaran.hitungLuas());
        System.out.printf("Keliling Lingkaran: %.2f\n", lingkaran.hitungKeliling());
    }
}
