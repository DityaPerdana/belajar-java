package com.belajar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

interface PembayaranStrategy {
    void prosesPembayaran(double jumlah);
}

class PembayaranTunai implements PembayaranStrategy {
    @Override
    public void prosesPembayaran(double jumlah) {
        System.out.printf("Pembayaran tunai sebesar Rp%.2f berhasil\n", jumlah);
    }
}

class PembayaranKartuKredit implements PembayaranStrategy {
    private String nomorKartu;
    private String nama;

    public PembayaranKartuKredit(String nomorKartu, String nama) {
        this.nomorKartu = nomorKartu;
        this.nama = nama;
    }

    @Override
    public void prosesPembayaran(double jumlah) {
        System.out.printf("Pembayaran kartu kredit sebesar Rp%.2f berhasil\n", jumlah);
        System.out.println("Nomor Kartu: " + nomorKartu);
        System.out.println("Nama: " + nama);
    }
}

class PembayaranEWallet implements PembayaranStrategy {
    private String provider;
    private String nomorTelepon;

    public PembayaranEWallet(String provider, String nomorTelepon) {
        this.provider = provider;
        this.nomorTelepon = nomorTelepon;
    }

    @Override
    public void prosesPembayaran(double jumlah) {
        System.out.printf("Pembayaran %s sebesar Rp%.2f berhasil\n", provider, jumlah);
        System.out.println("Nomor Telepon: " + nomorTelepon);
    }
}

class MenuMakanan {
    private String nama;
    private double harga;
    private String deskripsi;

    public MenuMakanan(String nama, double harga, String deskripsi) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public String getDeskripsi() { return deskripsi; }
}

class Pesanan {
    private Map<MenuMakanan, Integer> items;
    private PembayaranStrategy metodePembayaran;

    public Pesanan() {
        this.items = new HashMap<>();
    }

    public void tambahItem(MenuMakanan menu, int jumlah) {
        items.merge(menu, jumlah, Integer::sum);
    }

    public void setMetodePembayaran(PembayaranStrategy metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public double hitungTotal() {
        return items.entrySet().stream()
            .mapToDouble(e -> e.getKey().getHarga() * e.getValue())
            .sum();
    }

    public void prosesPembayaran() {
        if (metodePembayaran == null) {
            System.out.println("Error: Metode pembayaran belum dipilih!");
            return;
        }

        System.out.println("\n=== Struk Pembayaran ===");
        items.forEach((menu, jumlah) -> 
            System.out.printf("%s x%d: Rp%.2f\n", 
                menu.getNama(), jumlah, menu.getHarga() * jumlah)
        );
        System.out.println("----------------------");
        System.out.printf("Total: Rp%.2f\n", hitungTotal());
        System.out.println("----------------------");
        
        metodePembayaran.prosesPembayaran(hitungTotal());
    }
}

class RestaurantApp {
    private List<MenuMakanan> daftarMenu;
    private Scanner scanner;

    public RestaurantApp() {
        this.daftarMenu = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        inisialisasiMenu();
    }

    private void inisialisasiMenu() {
        daftarMenu.add(new MenuMakanan("Nasi Goreng Spesial", 25000, 
            "Nasi goreng dengan telur, ayam, dan sayuran"));
        daftarMenu.add(new MenuMakanan("Mie Goreng", 22000, 
            "Mie goreng dengan telur dan sayuran"));
        daftarMenu.add(new MenuMakanan("Sate Ayam", 30000, 
            "10 tusuk sate ayam dengan bumbu kacang"));
        daftarMenu.add(new MenuMakanan("Gado-gado", 20000, 
            "Sayuran segar dengan bumbu kacang"));
    }

    public void tampilkanMenu() {
        System.out.println("\n=== Menu Makanan ===");
        for (int i = 0; i < daftarMenu.size(); i++) {
            MenuMakanan menu = daftarMenu.get(i);
            System.out.printf("%d. %s - Rp%.2f\n", (i + 1), 
                menu.getNama(), menu.getHarga());
            System.out.println("   " + menu.getDeskripsi());
        }
    }

    public void prosesOrder() {
        Pesanan pesanan = new Pesanan();
        boolean lanjutPesan = true;

        while (lanjutPesan) {
            tampilkanMenu();
            System.out.print("\nPilih menu (0 untuk selesai): ");
            int pilihan = scanner.nextInt();

            if (pilihan == 0) {
                lanjutPesan = false;
            } else if (pilihan >= 1 && pilihan <= daftarMenu.size()) {
                System.out.print("Jumlah pesanan: ");
                int jumlah = scanner.nextInt();
                pesanan.tambahItem(daftarMenu.get(pilihan - 1), jumlah);
            } else {
                System.out.println("Menu tidak valid!");
            }
        }

        if (pesanan.hitungTotal() > 0) {
            pilihMetodePembayaran(pesanan);
            pesanan.prosesPembayaran();
        }
    }

    private void pilihMetodePembayaran(Pesanan pesanan) {
        System.out.println("\n=== Metode Pembayaran ===");
        System.out.println("1. Tunai");
        System.out.println("2. Kartu Kredit");
        System.out.println("3. E-Wallet");
        
        System.out.print("Pilih metode pembayaran: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (pilihan) {
            case 1:
                pesanan.setMetodePembayaran(new PembayaranTunai());
                break;
            case 2:
                System.out.print("Masukkan nomor kartu: ");
                String nomorKartu = scanner.nextLine();
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                pesanan.setMetodePembayaran(new PembayaranKartuKredit(nomorKartu, nama));
                break;
            case 3:
                System.out.print("Pilih provider (GoPay/OVO/DANA): ");
                String provider = scanner.nextLine();
                System.out.print("Masukkan nomor telepon: ");
                String nomorTelepon = scanner.nextLine();
                pesanan.setMetodePembayaran(new PembayaranEWallet(provider, nomorTelepon));
                break;
            default:
                System.out.println("Metode pembayaran tidak valid!");
        }
    }
}

public class Latihan29 {
    public static void main(String[] args) {
        System.out.println("=== Selamat Datang di Restoran ===");
        
        RestaurantApp app = new RestaurantApp();
        app.prosesOrder();
    }
}
