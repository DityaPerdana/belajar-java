package com.belajar;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class ifElse {
    public static void main(String[] args) {
        LocalDate hariIni = LocalDate.now();
        DayOfWeek hari = hariIni.getDayOfWeek();
        
        System.out.println("=== Menggunakan Switch Case Tradisional ===");
        switch (hari) {
            case MONDAY:
                System.out.println("Hari ini adalah Senin");
                break;
            case TUESDAY:
                System.out.println("Hari ini adalah Selasa");
                break;
            case WEDNESDAY:
                System.out.println("Hari ini adalah Rabu");
                break;
            case THURSDAY:
                System.out.println("Hari ini adalah Kamis");
                break;
            case FRIDAY:
                System.out.println("Hari ini adalah Jumat");
                break;
            case SATURDAY:
                System.out.println("Hari ini adalah Sabtu");
                break;
            case SUNDAY:
                System.out.println("Hari ini adalah Minggu");
                break;
            default:
                System.out.println("Hari tidak valid");
        }
    }
}
