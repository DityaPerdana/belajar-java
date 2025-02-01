package com.belajar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class Karakter {
    private String nama;
    private int health;
    private int damage;
    private boolean isAlive;

    public Karakter(String nama, int health, int damage) {
        this.nama = nama;
        this.health = health;
        this.damage = damage;
        this.isAlive = true;
    }

    public String getNama() { return nama; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public boolean isAlive() { return isAlive; }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            isAlive = false;
        }
    }

    public void heal(int amount) {
        if (isAlive) {
            health += amount;
        }
    }
}

class Tim {
    private String nama;
    private List<Karakter> anggota;
    private AtomicInteger score;

    public Tim(String nama) {
        this.nama = nama;
        this.anggota = new ArrayList<>();
        this.score = new AtomicInteger(0);
    }

    public void tambahKarakter(Karakter karakter) {
        anggota.add(karakter);
    }

    public String getNama() { return nama; }
    public List<Karakter> getAnggota() { return anggota; }
    public int getScore() { return score.get(); }
    public void addScore(int points) { score.addAndGet(points); }

    public boolean masihHidup() {
        return anggota.stream().anyMatch(Karakter::isAlive);
    }
}

class BattleArena {
    private Random random;

    public BattleArena() {
        this.random = new Random();
    }

    public void mulaiPertarungan(Tim tim1, Tim tim2) {
        System.out.println("=== Pertarungan Dimulai ===");
        System.out.println(tim1.getNama() + " VS " + tim2.getNama() + "\n");

        int ronde = 1;
        while (tim1.masihHidup() && tim2.masihHidup()) {
            System.out.println("=== Ronde " + ronde + " ===");
            
            // Tim 1 menyerang Tim 2
            serangTim(tim1, tim2);
            if (!tim2.masihHidup()) break;

            // Tim 2 menyerang Tim 1
            serangTim(tim2, tim1);
            if (!tim1.masihHidup()) break;

            // Tampilkan status setelah ronde
            tampilkanStatus(tim1);
            tampilkanStatus(tim2);
            System.out.println();

            ronde++;
            
            // Jeda antar ronde
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Tentukan pemenang
        Tim pemenang = tim1.masihHidup() ? tim1 : tim2;
        pemenang.addScore(100);
        
        System.out.println("\n=== Pertarungan Selesai ===");
        System.out.println("Pemenang: " + pemenang.getNama());
        System.out.println("Score: " + pemenang.getScore());
    }

    private void serangTim(Tim penyerang, Tim bertahan) {
        List<Karakter> penyerangHidup = penyerang.getAnggota().stream()
            .filter(Karakter::isAlive)
            .toList();
        
        List<Karakter> bertahanHidup = bertahan.getAnggota().stream()
            .filter(Karakter::isAlive)
            .toList();

        if (!penyerangHidup.isEmpty() && !bertahanHidup.isEmpty()) {
            Karakter attacker = penyerangHidup.get(random.nextInt(penyerangHidup.size()));
            Karakter defender = bertahanHidup.get(random.nextInt(bertahanHidup.size()));

            defender.takeDamage(attacker.getDamage());
            System.out.printf("%s dari tim %s menyerang %s dari tim %s (Damage: %d)\n",
                attacker.getNama(), penyerang.getNama(),
                defender.getNama(), bertahan.getNama(),
                attacker.getDamage());

            if (!defender.isAlive()) {
                System.out.println(defender.getNama() + " telah dikalahkan!");
                penyerang.addScore(10);
            }
        }
    }

    private void tampilkanStatus(Tim tim) {
        System.out.println("\nStatus " + tim.getNama() + ":");
        tim.getAnggota().forEach(k -> 
            System.out.printf("- %s: %d HP %s\n", 
                k.getNama(), k.getHealth(),
                k.isAlive() ? "" : "(Dikalahkan)")
        );
    }
}

public class Latihan28 {
    public static void main(String[] args) {
        // Membuat tim pertama
        Tim tim1 = new Tim("Pahlawan");
        tim1.tambahKarakter(new Karakter("Ksatria", 100, 20));
        tim1.tambahKarakter(new Karakter("Pemanah", 80, 25));
        tim1.tambahKarakter(new Karakter("Penyihir", 70, 30));

        // Membuat tim kedua
        Tim tim2 = new Tim("Monster");
        tim2.tambahKarakter(new Karakter("Goblin", 60, 15));
        tim2.tambahKarakter(new Karakter("Orc", 120, 18));
        tim2.tambahKarakter(new Karakter("Troll", 150, 22));

        // Memulai pertarungan
        BattleArena arena = new BattleArena();
        arena.mulaiPertarungan(tim1, tim2);
    }
}
