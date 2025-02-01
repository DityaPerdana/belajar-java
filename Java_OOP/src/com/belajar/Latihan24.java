package com.belajar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface Observer {
    void update(String message);
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

class WeatherStation implements Subject {
    private List<Observer> observers;
    private double temperature;
    private double humidity;
    private double pressure;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.update(message));
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        
        // Membuat pesan cuaca
        String weatherMessage = String.format(
            "Kondisi Cuaca Terkini:\nSuhu: %.1f°C\nKelembaban: %.1f%%\nTekanan: %.1f hPa",
            temperature, humidity, pressure
        );
        
        // Menambahkan peringatan jika diperlukan
        Optional<String> warning = generateWarning();
        if (warning.isPresent()) {
            weatherMessage += "\n\nPERINGATAN: " + warning.get();
        }
        
        notifyObservers(weatherMessage);
    }

    private Optional<String> generateWarning() {
        if (temperature > 35) {
            return Optional.of("Suhu sangat tinggi! Hindari aktivitas di luar ruangan.");
        } else if (temperature < 10) {
            return Optional.of("Suhu sangat rendah! Gunakan pakaian yang hangat.");
        } else if (humidity > 85) {
            return Optional.of("Kelembaban tinggi! Kemungkinan hujan.");
        } else if (pressure < 1000) {
            return Optional.of("Tekanan udara rendah! Waspada cuaca buruk.");
        }
        return Optional.empty();
    }
}

class WeatherDisplay implements Observer {
    private String location;

    public WeatherDisplay(String location) {
        this.location = location;
    }

    @Override
    public void update(String message) {
        System.out.println("\nUpdate Cuaca untuk " + location + ":");
        System.out.println(message);
        System.out.println("----------------------------------------");
    }
}

class MobileApp implements Observer {
    private String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String message) {
        System.out.println("\nNotifikasi Mobile App untuk " + userName + ":");
        System.out.println(message);
        System.out.println("----------------------------------------");
    }
}

public class Latihan24 {
    public static void main(String[] args) {
        // Membuat weather station
        WeatherStation weatherStation = new WeatherStation();

        // Membuat observers
        WeatherDisplay displayKota = new WeatherDisplay("Jakarta Pusat");
        WeatherDisplay displayBandara = new WeatherDisplay("Bandara Soekarno-Hatta");
        MobileApp userApp = new MobileApp("Budi Santoso");

        // Mendaftarkan observers
        weatherStation.registerObserver(displayKota);
        weatherStation.registerObserver(displayBandara);
        weatherStation.registerObserver(userApp);

        // Simulasi perubahan cuaca
        System.out.println("=== Simulasi Pemantauan Cuaca ===\n");
        
        // Cuaca normal
        weatherStation.setMeasurements(28.5, 65.0, 1013.2);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cuaca panas
        weatherStation.setMeasurements(36.8, 55.0, 1012.0);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Kemungkinan hujan
        weatherStation.setMeasurements(27.5, 88.0, 1009.5);
    }
}
