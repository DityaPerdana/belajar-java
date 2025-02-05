package com.belajar;
import javax.swing.JOptionPane;

public class Latihan31 {
    public static void main(String[] args) {
        for (int i = 0; i < 9999; i++) {
            System.out.println("Perulangan ke-" + i);
        
        String nama;
        nama = JOptionPane.showInputDialog("Masukkan Nama Anda: ");
        String msg = "Halo, " + nama + "!";
        JOptionPane.showMessageDialog(null, msg);
        }
}
}



