package com.belajar;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class PemesananMakanan {
    private String namaPelanggan;
    private List<String> pesanan;
    private StatusPesanan status;
    private Timer timer;

    enum StatusPesanan {
        DITERIMA("Pesanan Diterima"),
        DIPROSES("Sedang Diproses"),
        SIAP("Siap Diambil"),
        SELESAI("Pesanan Selesai");

        private String deskripsi;

        StatusPesanan(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public String getDeskripsi() {
            return deskripsi;
        }
    }

    public PemesananMakanan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
        this.pesanan = new ArrayList<>();
        this.status = StatusPesanan.DITERIMA;
        this.timer = new Timer();
    }

    public void tambahMenu(String menu) {
        pesanan.add(menu);
        System.out.println("Menu " + menu + " ditambahkan ke pesanan");
    }

    public void mulaiProsesPesanan() {
        System.out.println("\nMemulai proses pesanan untuk " + namaPelanggan);
        tampilkanStatus();

        // Simulasi proses pesanan dengan timer
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                status = StatusPesanan.DIPROSES;
                System.out.println("\nUpdate status pesanan " + namaPelanggan + ":");
                tampilkanStatus();
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                status = StatusPesanan.SIAP;
                System.out.println("\nUpdate status pesanan " + namaPelanggan + ":");
                tampilkanStatus();
            }
        }, 4000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                status = StatusPesanan.SELESAI;
                System.out.println("\nUpdate status pesanan " + namaPelanggan + ":");
                tampilkanStatus();
                timer.cancel();
            }
        }, 6000);
    }

    public void tampilkanStatus() {
        System.out.println("Status: " + status.getDeskripsi());
        System.out.println("Daftar Pesanan:");
        for (int i = 0; i < pesanan.size(); i++) {
            System.out.println((i + 1) + ". " + pesanan.get(i));
        }
    }
}

public class Latihan21 {
    public static void main(String[] args) {
        PemesananMakanan pesanan = new PemesananMakanan("Budi Santoso");
        
        pesanan.tambahMenu("Nasi Goreng Spesial");
        pesanan.tambahMenu("Juice Mangga");
        pesanan.tambahMenu("Es Krim Vanilla");
        
        pesanan.mulaiProsesPesanan();
        
        // Program akan berjalan selama 7 detik untuk menampilkan semua status
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
