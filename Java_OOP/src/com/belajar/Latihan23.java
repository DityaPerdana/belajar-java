package com.belajar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Smartphone {
    private String merk;
    private String model;
    private int tahun;
    private double harga;
    private List<String> fitur;

    public Smartphone(String merk, String model, int tahun, double harga) {
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
        this.harga = harga;
        this.fitur = new ArrayList<>();
    }

    public void tambahFitur(String fitur) {
        this.fitur.add(fitur);
    }

    public String getMerk() { return merk; }
    public String getModel() { return model; }
    public int getTahun() { return tahun; }
    public double getHarga() { return harga; }
    public List<String> getFitur() { return fitur; }

    @Override
    public String toString() {
        return String.format("%s %s (%d) - Rp%.2f\nFitur: %s", 
            merk, model, tahun, harga, 
            String.join(", ", fitur));
    }
}

class TokoSmartphone {
    private List<Smartphone> daftarSmartphone;

    public TokoSmartphone() {
        daftarSmartphone = new ArrayList<>();
    }

    public void tambahSmartphone(Smartphone smartphone) {
        daftarSmartphone.add(smartphone);
    }

    public List<Smartphone> cariSmartphone(Predicate<Smartphone> kriteria) {
        return daftarSmartphone.stream()
                              .filter(kriteria)
                              .collect(Collectors.toList());
    }

    public void tampilkanHasilPencarian(List<Smartphone> hasil, String kriteriaPencarian) {
        System.out.println("\nHasil pencarian " + kriteriaPencarian + ":");
        System.out.println("----------------------------------------");
        if (hasil.isEmpty()) {
            System.out.println("Tidak ditemukan smartphone yang sesuai kriteria");
        } else {
            hasil.forEach(s -> {
                System.out.println(s);
                System.out.println("----------------------------------------");
            });
        }
    }
}

public class Latihan23 {
    public static void main(String[] args) {
        TokoSmartphone toko = new TokoSmartphone();

        // Menambahkan data smartphone
        Smartphone hp1 = new Smartphone("Samsung", "Galaxy S21", 2021, 12000000);
        hp1.tambahFitur("5G");
        hp1.tambahFitur("Triple Camera");
        hp1.tambahFitur("Wireless Charging");
        toko.tambahSmartphone(hp1);

        Smartphone hp2 = new Smartphone("iPhone", "13 Pro", 2021, 18000000);
        hp2.tambahFitur("5G");
        hp2.tambahFitur("LiDAR Scanner");
        hp2.tambahFitur("Face ID");
        toko.tambahSmartphone(hp2);

        Smartphone hp3 = new Smartphone("Xiaomi", "Redmi Note 10", 2021, 3000000);
        hp3.tambahFitur("Quad Camera");
        hp3.tambahFitur("Fast Charging");
        hp3.tambahFitur("NFC");
        toko.tambahSmartphone(hp3);

        // Mencari smartphone dengan berbagai kriteria menggunakan lambda
        List<Smartphone> hasilHargaDibawah5Juta = toko.cariSmartphone(hp -> hp.getHarga() < 5000000);
        toko.tampilkanHasilPencarian(hasilHargaDibawah5Juta, "smartphone dengan harga di bawah 5 juta");

        List<Smartphone> hasilMerkSamsung = toko.cariSmartphone(hp -> hp.getMerk().equalsIgnoreCase("Samsung"));
        toko.tampilkanHasilPencarian(hasilMerkSamsung, "smartphone merk Samsung");

        List<Smartphone> hasilFitur5G = toko.cariSmartphone(
            hp -> hp.getFitur().stream().anyMatch(f -> f.contains("5G"))
        );
        toko.tampilkanHasilPencarian(hasilFitur5G, "smartphone dengan fitur 5G");
    }
}
