package com.belajar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LuasLingkaran {
    int r;
    double phi = 3.14;

    void isi(int r, double phi) {
        this.r = r;
        this.phi = phi;
    }

    double hitungLuas() {
        return phi * r * r;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        LuasLingkaran lingkaran = new LuasLingkaran();
        System.out.print("Masukkan jari-jari lingkaran: ");
        int r = Integer.parseInt(br.readLine());
        lingkaran.isi(r, 3.14);
        System.out.print("Luas lingkaran adalah: " + lingkaran.hitungLuas());
    }
}
