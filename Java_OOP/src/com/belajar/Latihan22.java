package com.belajar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class PasienRumahSakit {
    private String nama;
    private String keluhan;
    private int prioritas; // 1 (tinggi) sampai 3 (rendah)

    public PasienRumahSakit(String nama, String keluhan, int prioritas) {
        this.nama = nama;
        this.keluhan = keluhan;
        this.prioritas = prioritas;
    }

    public String getNama() { return nama; }
    public String getKeluhan() { return keluhan; }
    public int getPrioritas() { return prioritas; }
}

class AntrianRumahSakit {
    private Queue<PasienRumahSakit> antrianPrioritas1;
    private Queue<PasienRumahSakit> antrianPrioritas2;
    private Queue<PasienRumahSakit> antrianPrioritas3;
    private Random random;

    public AntrianRumahSakit() {
        antrianPrioritas1 = new LinkedList<>();
        antrianPrioritas2 = new LinkedList<>();
        antrianPrioritas3 = new LinkedList<>();
        random = new Random();
    }

    public void tambahPasien(PasienRumahSakit pasien) {
        switch (pasien.getPrioritas()) {
            case 1:
                antrianPrioritas1.offer(pasien);
                break;
            case 2:
                antrianPrioritas2.offer(pasien);
                break;
            case 3:
                antrianPrioritas3.offer(pasien);
                break;
        }
        System.out.printf("Pasien %s ditambahkan ke antrian prioritas %d\n", 
            pasien.getNama(), pasien.getPrioritas());
    }

    public void prosesAntrian() {
        while (!antrianKosong()) {
            PasienRumahSakit pasien = panggilPasien();
            if (pasien != null) {
                System.out.println("\nMemproses pasien:");
                System.out.println("Nama: " + pasien.getNama());
                System.out.println("Keluhan: " + pasien.getKeluhan());
                System.out.println("Prioritas: " + pasien.getPrioritas());
                
                // Simulasi waktu pemeriksaan
                try {
                    Thread.sleep(random.nextInt(2000) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("\nSemua antrian telah selesai diproses");
    }

    private PasienRumahSakit panggilPasien() {
        if (!antrianPrioritas1.isEmpty()) {
            return antrianPrioritas1.poll();
        } else if (!antrianPrioritas2.isEmpty()) {
            return antrianPrioritas2.poll();
        } else if (!antrianPrioritas3.isEmpty()) {
            return antrianPrioritas3.poll();
        }
        return null;
    }

    private boolean antrianKosong() {
        return antrianPrioritas1.isEmpty() && 
               antrianPrioritas2.isEmpty() && 
               antrianPrioritas3.isEmpty();
    }
}

public class Latihan22 {
    public static void main(String[] args) {
        AntrianRumahSakit antrian = new AntrianRumahSakit();

        // Menambahkan pasien dengan berbagai prioritas
        antrian.tambahPasien(new PasienRumahSakit("Andi", "Kecelakaan", 1));
        antrian.tambahPasien(new PasienRumahSakit("Budi", "Demam", 3));
        antrian.tambahPasien(new PasienRumahSakit("Citra", "Sesak Nafas", 2));
        antrian.tambahPasien(new PasienRumahSakit("Deni", "Patah Tulang", 1));
        antrian.tambahPasien(new PasienRumahSakit("Eva", "Flu", 3));

        // Memproses antrian
        System.out.println("\nMulai memproses antrian...");
        antrian.prosesAntrian();
    }
}
