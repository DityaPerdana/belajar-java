package com.belajar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Latihan33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // daftar barang
        String[] namaBarang = {
                "Beras", "Minyak Goreng", "Gula", "Kopi", "Teh",
                "Susu", "Roti", "Telur", "Mie Instan", "Sabun Mandi",
                "Shampo", "Pasta Gigi", "Sikat Gigi", "Deterjen", "Pewangi",
                "Tissue", "Air Mineral", "Sarden", "Biskuit", "Permen",
                "Coklat", "Keripik", "Wafer", "Minyak Kayu Putih", "Plester",
                "Obat Batuk", "Vitamin C", "Masker", "Hand Sanitizer", "Sabun Cuci Tangan",
                "Kecap", "Saos", "Sambal", "Bumbu Masak", "Garam",
                "Merica", "Bawang Putih", "Bawang Merah", "Cabai", "Tomat",
                "Wortel", "Kentang", "Kubis", "Bayam", "Kangkung",
                "Apel", "Jeruk", "Pisang", "Mangga", "Anggur",
                "Susu Kotak", "Yogurt", "Es Krim", "Mentega", "Margarin",
                "Keju", "Sosis", "Nugget", "Bakso", "Tahu",
                "Tempe", "Ikan Segar", "Ayam", "Daging Sapi", "Udang",
                "Tepung Terigu", "Tepung Beras", "Tepung Tapioka", "Maizena", "Bumbu Instan",
                "Kopi Sachet", "Teh Celup", "Susu Bubuk", "Madu", "Selai",
                "Sarden Kaleng", "Kornet", "Mayonaise", "Kue Kering", "Kerupuk",
                "Minuman Soda", "Jus Kemasan", "Sirup", "Mie Telur", "Bihun",
                "Makaroni", "Spageti", "Sambal Botol", "Kecap Botol", "Saos Botol",
                "Minyak Wangi", "Bedak", "Lipstik", "Deodoran", "Kapas",
                "Pembalut", "Tisu Basah", "Tisu Kering", "Cotton Bud",
        };
        // harga barang
        int[] hargaBarang = {
                65000, 35000, 15000, 25000, 8000,
                18000, 12000, 28000, 3500, 5000,
                22000, 15000, 8000, 20000, 18000,
                12000, 5000, 15000, 8000, 2000,
                12000, 10000, 7000, 25000, 10000,
                15000, 35000, 2000, 15000, 12000,
                12000, 10000, 12000, 5000, 3000,
                2000, 35000, 30000, 40000, 8000,
                12000, 15000, 8000, 5000, 4000,
                25000, 20000, 15000, 35000, 45000,
                8000, 10000, 15000, 12000, 8000,
                25000, 28000, 35000, 25000, 5000,
                4000, 35000, 32000, 120000, 45000,
                12000, 10000, 8000, 7000, 3500,
                2500, 5000, 38000, 45000, 15000,
                18000, 25000, 18000, 35000, 8000,
                7000, 8000, 12000, 4500, 3500,
                12000, 15000, 15000, 18000, 20000,
                85000, 25000, 45000, 28000, 8000,
                22000, 12000, 15000, 5000,
        };
        // stok barang
        int[] stokBarang = {
                10, 20, 15, 25, 30,
                18, 12, 28, 35, 50,
                22, 15, 8, 20, 18,
                12, 5, 15, 8, 20,
                12, 10, 7, 25, 10,
                15, 35, 20, 15, 12,
                12, 10, 12, 5, 3,
                2, 35, 30, 40, 8,
                12, 15, 8, 5, 4,
                25, 20, 15, 35, 45,
                8, 10, 15, 12, 8,
                25, 28, 35, 25, 5,
                4, 35, 32, 12, 45,
                12, 10, 8, 7, 35,
                25, 50, 38, 45, 15,
                18, 25, 18, 35, 8,
                7, 8, 12, 45, 35,
                12, 15, 15, 18, 20,
                85, 25, 45, 28, 8,
                22, 12, 15, 5,
        };

        int totalHarga = 0;
        List<String> daftarBelanja = new ArrayList<>();

        while (true) {
            System.out.println("\n=== SISTEM MINIMARKET ===");
            System.out.println("1. Lihat Daftar Barang");
            System.out.println("2. Pilih Barang untuk Dibeli");
            System.out.println("3. Lihat Total Harga dan Daftar Barang yang Dibeli");
            System.out.println("4. Konfirmasi Pembelian");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("\nDAFTAR BARANG MINIMARKET:");
                    System.out.println("No.\tNama Barang\t\tHarga\t\tStok");
                    System.out.println("=================================================");
                    for (int i = 0; i < namaBarang.length; i++) {
                        System.out.printf("%d.\t%-20s\tRp %,d\t\t%d%n",
                                (i + 1), namaBarang[i], hargaBarang[i], stokBarang[i]);
                    }
                    break;

                case 2:
                    for (int i = 0; i < namaBarang.length; i++) {
                        System.out.printf("%d.\t%-20s\tRp %,d\t\t%d%n",
                                (i + 1), namaBarang[i], hargaBarang[i], stokBarang[i]);
                    }
                    System.out.print("\nMasukkan nomor barang yang ingin dibeli (1-99): ");
                    int nomor = scanner.nextInt();
                    if (nomor >= 1 && nomor <= 99) {
                        System.out.print("Masukkan jumlah barang yang ingin dibeli: ");
                        int jumlah = scanner.nextInt();
                        if (jumlah > 0 && jumlah <= stokBarang[nomor - 1]) {
                            totalHarga += hargaBarang[nomor - 1] * jumlah;
                            for (int i = 0; i < jumlah; i++) {
                                daftarBelanja.add(namaBarang[nomor - 1]);
                            }
                            stokBarang[nomor - 1] -= jumlah;
                            System.out
                                    .println(jumlah + " " + namaBarang[nomor - 1] + " telah ditambahkan ke keranjang.");
                        } else {
                            System.out.println("Jumlah barang tidak valid atau stok tidak mencukupi!");
                        }
                    } else {
                        System.out.println("Nomor barang tidak valid!");
                    }
                    break;

                    case 3:
                    System.out.printf("Total harga barang yang dibeli: Rp %,d%n", totalHarga);
                    System.out.println("Daftar barang yang dibeli:");
                    for (String barang : daftarBelanja) {
                        System.out.println("- " + barang);
                    }
                    System.out.println("\n5. Bayar");
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem minimarket!");
                    scanner.close();
                    return;

                    case 4:
                    System.out.printf("Total harga barang yang dibeli: Rp %,d%n", totalHarga);
                    System.out.print("Masukkan jumlah uang yang dibayarkan: ");
                    int uangDibayarkan = scanner.nextInt();
                    if (uangDibayarkan >= totalHarga) {
                        int kembalian = uangDibayarkan - totalHarga;
                        System.out.printf("Kembalian: Rp %,d%n", kembalian);
                        System.out.println("\n=== STRUK BELANJA ===");
                        for (String barang : daftarBelanja) {
                            System.out.println("- " + barang);
                        }
                        System.out.printf("Total harga: Rp %,d%n", totalHarga);
                        System.out.printf("Uang dibayarkan: Rp %,d%n", uangDibayarkan);
                        System.out.printf("Kembalian: Rp %,d%n", kembalian);
                        System.out.println("=====================");
                    } else {
                        System.out.println("Uang yang dibayarkan tidak mencukupi!");
                    }
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}