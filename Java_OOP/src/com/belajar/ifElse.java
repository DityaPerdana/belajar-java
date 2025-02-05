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
                System.out.println("Semangat memulai minggu! 💪");
                break;
            case TUESDAY:
                System.out.println("Hari ini adalah Selasa");
                System.out.println("Tetap produktif! 📚");
                break;
            case WEDNESDAY:
                System.out.println("Hari ini adalah Rabu");
                System.out.println("Semangat, sudah pertengahan minggu! 🌟");
                break;
            case THURSDAY:
                System.out.println("Hari ini adalah Kamis");
                System.out.println("Jangan lupa istirahat! 😊");
                break;
            case FRIDAY:
                System.out.println("Hari ini adalah Jumat");
                System.out.println("Hari yang diberkahi! 🕌");
                break;
            case SATURDAY:
                System.out.println("Hari ini adalah Sabtu");
                System.out.println("Waktunya weekend! 🎉");
                break;
            case SUNDAY:
                System.out.println("Hari ini adalah Minggu");
                System.out.println("Selamat beristirahat! 🌞");
                break;
            default:
                System.out.println("Hari tidak valid");
        }
    }
}
