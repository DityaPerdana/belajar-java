package com.belajar;

import java.util.Stack;
import java.util.Scanner;

class EditorTeks {
    private Stack<String> undoStack;
    private Stack<String> redoStack;
    private StringBuilder currentText;

    public EditorTeks() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        currentText = new StringBuilder();
    }

    public void ketik(String text) {
        undoStack.push(currentText.toString());
        currentText.append(text);
        redoStack.clear(); // Clear redo stack when new text is typed
        System.out.println("Mengetik: " + text);
        tampilkanStatus();
    }

    public void hapus(int jumlahKarakter) {
        if (currentText.length() >= jumlahKarakter) {
            undoStack.push(currentText.toString());
            currentText.setLength(currentText.length() - jumlahKarakter);
            redoStack.clear();
            System.out.println("Menghapus " + jumlahKarakter + " karakter");
            tampilkanStatus();
        } else {
            System.out.println("Tidak dapat menghapus: teks terlalu pendek");
        }
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText.toString());
            currentText = new StringBuilder(undoStack.pop());
            System.out.println("Undo dilakukan");
            tampilkanStatus();
        } else {
            System.out.println("Tidak dapat undo: tidak ada perubahan sebelumnya");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText.toString());
            currentText = new StringBuilder(redoStack.pop());
            System.out.println("Redo dilakukan");
            tampilkanStatus();
        } else {
            System.out.println("Tidak dapat redo: tidak ada perubahan untuk diulang");
        }
    }

    public void tampilkanStatus() {
        System.out.println("Teks saat ini: \"" + currentText.toString() + "\"");
        System.out.println("Panjang teks: " + currentText.length() + " karakter");
        System.out.println("Jumlah undo tersedia: " + undoStack.size());
        System.out.println("Jumlah redo tersedia: " + redoStack.size());
        System.out.println("----------------------------------------");
    }
}

public class Latihan25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EditorTeks editor = new EditorTeks();
        
        System.out.println("=== Editor Teks Sederhana ===");
        System.out.println("Perintah yang tersedia:");
        System.out.println("1. ketik <teks> - Menambah teks");
        System.out.println("2. hapus <jumlah> - Menghapus karakter dari belakang");
        System.out.println("3. undo - Membatalkan perubahan terakhir");
        System.out.println("4. redo - Mengulangi perubahan yang dibatalkan");
        System.out.println("5. keluar - Mengakhiri program");
        System.out.println("----------------------------------------");

        while (true) {
            System.out.print("\nMasukkan perintah: ");
            String perintah = scanner.nextLine().trim();

            if (perintah.equals("keluar")) {
                break;
            } else if (perintah.startsWith("ketik ")) {
                String teks = perintah.substring(6);
                editor.ketik(teks);
            } else if (perintah.startsWith("hapus ")) {
                try {
                    int jumlah = Integer.parseInt(perintah.substring(6));
                    editor.hapus(jumlah);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Masukkan jumlah karakter yang valid");
                }
            } else if (perintah.equals("undo")) {
                editor.undo();
            } else if (perintah.equals("redo")) {
                editor.redo();
            } else {
                System.out.println("Perintah tidak dikenali");
            }
        }

        System.out.println("\nTerima kasih telah menggunakan editor teks!");
        scanner.close();
    }
}
