package com.belajar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Barang {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Barang(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    
    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }

    @Override
    public String toString() {
        return String.format("%-6s %-20s Rp%-10.2f %d", kode, nama, harga, stok);
    }
}

class SistemInventori {
    private List<Barang> daftarBarang;
    private Scanner scanner;

    public SistemInventori() {
        daftarBarang = new ArrayList<>();
        scanner = new Scanner(System.in);
        inisialisasiBarang();
    }

    private void inisialisasiBarang() {
        daftarBarang.add(new Barang("B001", "Pensil", 3000, 100));
        daftarBarang.add(new Barang("B002", "Buku Tulis", 5000, 50));
        daftarBarang.add(new Barang("B003", "Penghapus", 2000, 75));
        daftarBarang.add(new Barang("B004", "Penggaris", 4000, 60));
    }

    public void tampilkanDaftarBarang() {
        System.out.println("\nDaftar Barang:");
        System.out.println("------------------------------------------------");
        System.out.println("Kode   Nama                 Harga       Stok");
        System.out.println("------------------------------------------------");
        for (Barang barang : daftarBarang) {
            System.out.println(barang);
        }
        System.out.println("------------------------------------------------");
    }

    public void prosesTransaksi() {
        List<Barang> keranjang = new ArrayList<>();
        List<Integer> jumlahBeli = new ArrayList<>();
        double totalHarga = 0;

        while (true) {
            tampilkanDaftarBarang();
            System.out.print("\nMasukkan kode barang (atau 'selesai' untuk checkout): ");
            String kode = scanner.next();

            if (kode.equalsIgnoreCase("selesai")) {
                break;
            }

            Barang barang = cariBarang(kode);
            if (barang == null) {
                System.out.println("Barang tidak ditemukan!");
                continue;
            }

            System.out.print("Jumlah beli: ");
            int jumlah = scanner.nextInt();

            if (jumlah > barang.getStok()) {
                System.out.println("Stok tidak mencukupi!");
                continue;
            }

            keranjang.add(barang);
            jumlahBeli.add(jumlah);
            totalHarga += barang.getHarga() * jumlah;
            barang.kurangiStok(jumlah);
        }

        if (!keranjang.isEmpty()) {
            cetakStruk(keranjang, jumlahBeli, totalHarga);
        }
    }

    private Barang cariBarang(String kode) {
        for (Barang barang : daftarBarang) {
            if (barang.getKode().equals(kode)) {
                return barang;
            }
        }
        return null;
    }

    private void cetakStruk(List<Barang> keranjang, List<Integer> jumlahBeli, double totalHarga) {
        System.out.println("\n================== STRUK PEMBELIAN ==================");
        System.out.println("Barang              Harga     Jumlah    Subtotal");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < keranjang.size(); i++) {
            Barang barang = keranjang.get(i);
            int jumlah = jumlahBeli.get(i);
            double subtotal = barang.getHarga() * jumlah;
            System.out.printf("%-18s %-9.2f %-9d %.2f\n", 
                barang.getNama(), barang.getHarga(), jumlah, subtotal);
        }
        
        System.out.println("--------------------------------------------------");
        System.out.printf("Total Harga: Rp%.2f\n", totalHarga);
        System.out.println("==================================================");
    }
}

public class Latihan20 {
    public static void main(String[] args) {
        System.out.println("=== Sistem Inventori Toko ===");
        
        SistemInventori sistem = new SistemInventori();
        sistem.prosesTransaksi();
    }
}
