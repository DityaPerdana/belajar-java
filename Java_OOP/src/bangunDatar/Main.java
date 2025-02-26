package bangunDatar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        int sisi;
        int alas;
        int tinggi;
        int r;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
    
        System.out.print("Masukkan sisi persegi: ");
        sisi = Integer.parseInt(br.readLine());
        System.out.print("Masukkan alas segitiga: ");
        alas = Integer.parseInt(br.readLine());
        System.out.print("Masukkan tinggi segitiga: ");
        tinggi = Integer.parseInt(br.readLine());
        System.out.print("Masukkan jari-jari lingkaran: ");
        r = Integer.parseInt(br.readLine());

        bangunDatar bangunan = new bangunDatar();
        Persegi kotak = new Persegi(sisi);
        Segitiga segitiga = new Segitiga(alas, tinggi);
        Lingkaran lingkaran = new Lingkaran(r);

        bangunan.luas();
        bangunan.keliling();

        System.out.println("Luas Persegi: " + kotak.luas()
                + "\nKeliling Persegi: " + kotak.keliling()
                + "\nLuas Segitiga: " + segitiga.luas()
                + "\nKeliling Segitiga: " + segitiga.keliling()
                + "\nLuas Lingkaran: " + lingkaran.luas()
                + "\nKeliling Lingkaran: " + lingkaran.keliling());   
    }
}


// _ _ _   
// _ __ __ _  __| (_) |_
// | '__/ _` |/ _` | | __|
// | | | (_| | (_| | | |_
// |_|  \__,_|\__,_|_|\__|