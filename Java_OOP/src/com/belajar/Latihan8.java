package com.belajar;

interface HitungLuas {
    double hitungLuas();
}

interface HitungKeliling {
    double hitungKeliling();
}

class Persegi implements HitungLuas, HitungKeliling {
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return sisi * sisi;
    }

    @Override
    public double hitungKeliling() {
        return 4 * sisi;
    }
}

public class Latihan8 {
    public static void main(String[] args) {
        Persegi persegi = new Persegi(5);
        
        System.out.println("=== Perhitungan Persegi ===");
        System.out.printf("Luas Persegi: %.2f\n", persegi.hitungLuas());
        System.out.printf("Keliling Persegi: %.2f\n", persegi.hitungKeliling());
    }
}
