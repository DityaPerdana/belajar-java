package com.belajar;
import java.util.Scanner;

public class ShapeCalculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Kalkulator Bangun Ruang 2D dan 3D ===");
            System.out.println("1. Bangun Datar (2D)");
            System.out.println("2. Bangun Ruang (3D)");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    hitungBangunDatar();
                    break;
                case 2:
                    hitungBangunRuang();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan kalkulator ini!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void hitungBangunDatar() {
        System.out.println("\n=== Bangun Datar ===");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Segitiga");
        System.out.println("4. Lingkaran");
        System.out.print("Pilih bangun datar (1-4): ");

        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                hitungPersegi();
                break;
            case 2:
                hitungPersegiPanjang();
                break;
            case 3:
                hitungSegitiga();
                break;
            case 4:
                hitungLingkaran();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    private static void hitungBangunRuang() {
        System.out.println("\n=== Bangun Ruang ===");
        System.out.println("1. Kubus");
        System.out.println("2. Balok");
        System.out.println("3. Tabung");
        System.out.println("4. Kerucut");
        System.out.print("Pilih bangun ruang (1-4): ");

        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                hitungKubus();
                break;
            case 2:
                hitungBalok();
                break;
            case 3:
                hitungTabung();
                break;
            case 4:
                hitungKerucut();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    private static void hitungPersegi() {
        System.out.print("Masukkan sisi persegi: ");
        double sisi = scanner.nextDouble();
        
        double luas = sisi * sisi;
        double keliling = 4 * sisi;
        
        System.out.println("\nHasil Perhitungan Persegi:");
        System.out.printf("Luas = %.2f\n", luas);
        System.out.printf("Keliling = %.2f\n", keliling);
    }

    private static void hitungPersegiPanjang() {
        System.out.print("Masukkan panjang: ");
        double panjang = scanner.nextDouble();
        System.out.print("Masukkan lebar: ");
        double lebar = scanner.nextDouble();
        
        double luas = panjang * lebar;
        double keliling = 2 * (panjang + lebar);
        
        System.out.println("\nHasil Perhitungan Persegi Panjang:");
        System.out.printf("Luas = %.2f\n", luas);
        System.out.printf("Keliling = %.2f\n", keliling);
    }

    private static void hitungSegitiga() {
        System.out.print("Masukkan alas: ");
        double alas = scanner.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi = scanner.nextDouble();
        System.out.print("Masukkan sisi 1: ");
        double sisi1 = scanner.nextDouble();
        System.out.print("Masukkan sisi 2: ");
        double sisi2 = scanner.nextDouble();
        System.out.print("Masukkan sisi 3: ");
        double sisi3 = scanner.nextDouble();
        
        double luas = 0.5 * alas * tinggi;
        double keliling = sisi1 + sisi2 + sisi3;
        
        System.out.println("\nHasil Perhitungan Segitiga:");
        System.out.printf("Luas = %.2f\n", luas);
        System.out.printf("Keliling = %.2f\n", keliling);
    }

    private static void hitungLingkaran() {
        System.out.print("Masukkan jari-jari: ");
        double radius = scanner.nextDouble();
        
        double luas = Math.PI * radius * radius;
        double keliling = 2 * Math.PI * radius;
        
        System.out.println("\nHasil Perhitungan Lingkaran:");
        System.out.printf("Luas = %.2f\n", luas);
        System.out.printf("Keliling = %.2f\n", keliling);
    }

    private static void hitungKubus() {
        System.out.print("Masukkan sisi kubus: ");
        double sisi = scanner.nextDouble();
        
        double volume = Math.pow(sisi, 3);
        double luasPermukaan = 6 * Math.pow(sisi, 2);
        
        System.out.println("\nHasil Perhitungan Kubus:");
        System.out.printf("Volume = %.2f\n", volume);
        System.out.printf("Luas Permukaan = %.2f\n", luasPermukaan);
    }

    private static void hitungBalok() {
        System.out.print("Masukkan panjang: ");
        double panjang = scanner.nextDouble();
        System.out.print("Masukkan lebar: ");
        double lebar = scanner.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi = scanner.nextDouble();
        
        double volume = panjang * lebar * tinggi;
        double luasPermukaan = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
        
        System.out.println("\nHasil Perhitungan Balok:");
        System.out.printf("Volume = %.2f\n", volume);
        System.out.printf("Luas Permukaan = %.2f\n", luasPermukaan);
    }

    private static void hitungTabung() {
        System.out.print("Masukkan jari-jari: ");
        double radius = scanner.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi = scanner.nextDouble();
        
        double volume = Math.PI * Math.pow(radius, 2) * tinggi;
        double luasPermukaan = 2 * Math.PI * radius * (radius + tinggi);
        
        System.out.println("\nHasil Perhitungan Tabung:");
        System.out.printf("Volume = %.2f\n", volume);
        System.out.printf("Luas Permukaan = %.2f\n", luasPermukaan);
    }

    private static void hitungKerucut() {
        System.out.print("Masukkan jari-jari: ");
        double radius = scanner.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi = scanner.nextDouble();
        
        double sisiMiring = Math.sqrt(Math.pow(radius, 2) + Math.pow(tinggi, 2));
        double volume = (1.0/3.0) * Math.PI * Math.pow(radius, 2) * tinggi;
        double luasPermukaan = Math.PI * radius * (radius + sisiMiring);
        
        System.out.println("\nHasil Perhitungan Kerucut:");
        System.out.printf("Volume = %.2f\n", volume);
        System.out.printf("Luas Permukaan = %.2f\n", luasPermukaan);
    }
}