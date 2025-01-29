package com.belajar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TugasHitung implements Runnable {
    private String nama;
    private int start;
    private int end;
    private long hasil;

    public TugasHitung(String nama, int start, int end) {
        this.nama = nama;
        this.start = start;
        this.end = end;
        this.hasil = 0;
    }

    @Override
    public void run() {
        System.out.println(nama + " mulai menghitung...");
        for (int i = start; i <= end; i++) {
            hasil += i;
            try {
                Thread.sleep(100); // Simulasi proses yang memakan waktu
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nama + " terganggu!");
                return;
            }
        }
        System.out.println(nama + " selesai menghitung. Hasil: " + hasil);
    }
}

public class Latihan17 {
    public static void main(String[] args) {
        System.out.println("=== Program Multi-Threading ===\n");
        
        // Membuat thread pool dengan 3 thread
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Membuat beberapa tugas
        TugasHitung tugas1 = new TugasHitung("Tugas-1", 1, 5);
        TugasHitung tugas2 = new TugasHitung("Tugas-2", 6, 10);
        TugasHitung tugas3 = new TugasHitung("Tugas-3", 11, 15);
        
        // Menjalankan tugas-tugas
        executor.submit(tugas1);
        executor.submit(tugas2);
        executor.submit(tugas3);
        
        // Mematikan executor
        executor.shutdown();
        
        try {
            // Menunggu semua tugas selesai (maksimal 10 detik)
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        
        System.out.println("\nSemua tugas telah selesai!");
    }
}
