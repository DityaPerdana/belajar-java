package com.belajar;
// Latihan method non void
public class Mobilku {
    String warna;
    int tahunProduksi;
    int nomorMesin;
    int nomorRangka;
    // method mengisi variabeel instance
    void isi(String warna, int tahunProduksi, int nomorMesin, int nomorRangka) {
        this.warna = warna;
        this.tahunProduksi = tahunProduksi;
        this.nomorMesin = nomorMesin;
        this.nomorRangka = nomorRangka;
    }
    String ambilWarna(){
        return warna;
    }
    int ambilTahunProduksi(){
        return tahunProduksi;
    }
    int ambilNomorMesin(){
        return nomorMesin;
    }
    int ambilNomorRangka(){
        return nomorRangka;
    } 
    String display(){
        return "Warna: " + warna + "\nTahun Produksi: " + tahunProduksi + "\nNomor Mesin: " + nomorMesin + "\nNomor Rangka: " + nomorRangka;
    }
    public static void main(String[] args) {
        Mobilku gripen = new Mobilku();

        gripen.isi("putih", 1444, 2, 2);

        System.out.println(gripen.display());
    }
}
