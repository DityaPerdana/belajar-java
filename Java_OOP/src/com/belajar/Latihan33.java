//#                                    "   
//mmmm    mmm   #   m          m mm   mmm   m mm   mmm   
//#" "#  "   #  # m"           #"  " #" "#  #"  #    #   
//#   #  m"""#  #"#            #     #   #  #   #    #   
//##m#"  "mm"#  #  "m          #     "#m#"  #   #  mm#mm 
//#


// tugas pak roni
package com.belajar;
import java.util.Scanner;

public class Latihan33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //daftar barang
        String[] namaBarang = {
            "Beras", "Minyak Goreng", "Gula", "Kopi", "Teh",
            "Susu", "Roti", "Telur", "Mie Instan", "Sabun Mandi",
            "Shampo", "Pasta Gigi", "Sikat Gigi", "Deterjen", "Pewangi",
            "Tissue", "Air Mineral", "Sarden", "Biskuit", "Permen",
            "Coklat", "Keripik", "Wafer", "Minyak Kayu Putih", "Plester",
            "Obat Batuk", "Vitamin C", "Masker", "Hand Sanitizer", "Sabun Cuci Tangan",
            "Kecap", "Saos", "Sambal", "Bumbu Masak", "Garam",
            "Merica", "Bawang Putih", "Bawang Merah", "Cabai", "Tomat",
            "Wortel", "Kentang", "Kubis", "Bayam", "Kangkung",
            "Apel", "Jeruk", "Pisang", "Mangga", "Anggur",
            "Susu Kotak", "Yogurt", "Es Krim", "Mentega", "Margarin",
            "Keju", "Sosis", "Nugget", "Bakso", "Tahu",
            "Tempe", "Ikan Segar", "Ayam", "Daging Sapi", "Udang",
            "Tepung Terigu", "Tepung Beras", "Tepung Tapioka", "Maizena", "Bumbu Instan",
            "Kopi Sachet", "Teh Celup", "Susu Bubuk", "Madu", "Selai",
            "Sarden Kaleng", "Kornet", "Mayonaise", "Kue Kering", "Kerupuk",
            "Minuman Soda", "Jus Kemasan", "Sirup", "Mie Telur", "Bihun",
            "Makaroni", "Spageti", "Sambal Botol", "Kecap Botol", "Saos Botol",
            "Minyak Wangi", "Bedak", "Lipstik", "Deodoran", "Kapas",
            "Pembalut", "Tisu Basah", "Tisu Kering", "Cotton Bud", "Sikat WC",
            "Pel Lantai", "Sapu", "Pengharum Ruangan", "Baygon"
        };

        // harga barang
        int[] hargaBarang = {
            65000, 35000, 15000, 25000, 8000,
            18000, 12000, 28000, 3500, 5000,
            22000, 15000, 8000, 20000, 18000,
            12000, 5000, 15000, 8000, 2000,
            12000, 10000, 7000, 25000, 10000,
            15000, 35000, 2000, 15000, 12000,
            12000, 10000, 12000, 5000, 3000,
            2000, 35000, 30000, 40000, 8000,
            12000, 15000, 8000, 5000, 4000,
            25000, 20000, 15000, 35000, 45000,
            8000, 10000, 15000, 12000, 8000,
            25000, 28000, 35000, 25000, 5000,
            4000, 35000, 32000, 120000, 45000,
            12000, 10000, 8000, 7000, 3500,
            2500, 5000, 38000, 45000, 15000,
            18000, 25000, 18000, 35000, 8000,
            7000, 8000, 12000, 4500, 3500,
            12000, 15000, 15000, 18000, 20000,
            85000, 25000, 45000, 28000, 8000,
            22000, 12000, 15000, 5000, 25000,
            35000, 28000, 35000, 45000
        };

        while (true) {
            System.out.println("\n=== SISTEM MINIMARKET ===");
            System.out.println("1. Lihat Daftar Barang");
            System.out.println("2. Cari Barang");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            
            int pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1:
                    System.out.println("\nDAFTAR BARANG MINIMARKET:");
                    System.out.println("No.\tNama Barang\t\tHarga");
                    System.out.println("=====================================");
                    for (int i = 0; i < namaBarang.length; i++) {
                        System.out.printf("%d.\t%-20s\tRp %,d%n", 
                            (i + 1), namaBarang[i], hargaBarang[i]);
                    }
                    break;
                    
                case 2:
                    System.out.print("\nMasukkan nomor barang (1-99): ");
                    int nomor = scanner.nextInt();
                    if (nomor >= 1 && nomor <= 99) {
                        System.out.println("\nDetail Barang:");
                        System.out.println("Nama: " + namaBarang[nomor-1]);
                        System.out.printf("Harga: Rp %,d%n", hargaBarang[nomor-1]);
                    } else {
                        System.out.println("Nomor barang tidak valid!");
                    }
                    break;
                    
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem minimarket!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
