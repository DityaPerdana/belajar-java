package com.belajar;

class BankAccount {
    private double saldo;
    private String nomorRekening;
    private static int jumlahAkun = 0;

    public BankAccount(String nomorRekening, double saldoAwal) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldoAwal;
        jumlahAkun++;
    }

    public void setor(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.printf("Berhasil setor Rp%.2f\n", jumlah);
        }
    }

    public void tarik(double jumlah) {
        if (jumlah <= saldo && jumlah > 0) {
            saldo -= jumlah;
            System.out.printf("Berhasil tarik Rp%.2f\n", jumlah);
        } else {
            System.out.println("Saldo tidak mencukupi atau jumlah tidak valid");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.printf("Saldo: Rp%.2f\n", saldo);
    }

    public static int getJumlahAkun() {
        return jumlahAkun;
    }
}

public class Latihan10 {
    public static void main(String[] args) {
        BankAccount akun1 = new BankAccount("1234567890", 1000000);
        BankAccount akun2 = new BankAccount("0987654321", 500000);

        System.out.println("=== Transaksi Bank ===");
        
        System.out.println("\nInfo Akun 1:");
        akun1.tampilkanInfo();
        akun1.setor(500000);
        akun1.tarik(200000);
        akun1.tampilkanInfo();

        System.out.println("\nInfo Akun 2:");
        akun2.tampilkanInfo();
        akun2.setor(1000000);
        akun2.tarik(1600000);
        akun2.tampilkanInfo();

        System.out.println("\nJumlah akun yang dibuat: " + BankAccount.getJumlahAkun());
    }
}
