package com.belajar;

class GenericBox<T> {
    private T isi;

    public void setIsi(T isi) {
        this.isi = isi;
    }

    public T getIsi() {
        return isi;
    }
}

class Produk {
    private String nama;
    private double harga;

    public Produk(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Produk{nama='" + nama + "', harga=" + harga + "}";
    }
}

public class Latihan14 {
    public static void main(String[] args) {
        System.out.println("=== Program Generic Class ===\n");

        // Generic box dengan String
        GenericBox<String> boxString = new GenericBox<>();
        boxString.setIsi("Halo, ini string dalam box!");
        System.out.println("Isi box string: " + boxString.getIsi());

        // Generic box dengan Integer
        GenericBox<Integer> boxInteger = new GenericBox<>();
        boxInteger.setIsi(100);
        System.out.println("Isi box integer: " + boxInteger.getIsi());

        // Generic box dengan custom class Produk
        GenericBox<Produk> boxProduk = new GenericBox<>();
        boxProduk.setIsi(new Produk("Laptop", 15000000));
        System.out.println("Isi box produk: " + boxProduk.getIsi());
    }
}
