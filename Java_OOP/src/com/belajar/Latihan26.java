package com.belajar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PizzaOrder {
    private String nama;
    private List<String> toppings;
    private boolean isReady;

    public PizzaOrder(String nama) {
        this.nama = nama;
        this.toppings = new ArrayList<>();
        this.isReady = false;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public String getNama() { return nama; }
    public List<String> getToppings() { return toppings; }
    public boolean isReady() { return isReady; }
    public void setReady(boolean ready) { isReady = ready; }
}

class PizzaKitchen {
    private ExecutorService executor;

    public PizzaKitchen(int chefs) {
        this.executor = Executors.newFixedThreadPool(chefs);
    }

    public CompletableFuture<PizzaOrder> preparePizza(PizzaOrder order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Mulai membuat pizza " + order.getNama());
                
                // Membuat adonan (2 detik)
                Thread.sleep(2000);
                System.out.println("Adonan pizza " + order.getNama() + " siap");

                // Menambahkan topping (1 detik per topping)
                for (String topping : order.getToppings()) {
                    Thread.sleep(1000);
                    System.out.println("Menambahkan " + topping + " ke pizza " + order.getNama());
                }

                // Memanggang pizza (3 detik)
                Thread.sleep(3000);
                System.out.println("Pizza " + order.getNama() + " sedang dipanggang");

                order.setReady(true);
                System.out.println("Pizza " + order.getNama() + " siap!");
                return order;

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Pembuatan pizza terganggu", e);
            }
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}

class PizzaDelivery {
    public static CompletableFuture<Void> deliverPizza(PizzaOrder order) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Kurir mengambil pizza " + order.getNama());
                Thread.sleep(2000);
                System.out.println("Kurir sedang mengantar pizza " + order.getNama());
                Thread.sleep(3000);
                System.out.println("Pizza " + order.getNama() + " telah diantar!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Pengantaran pizza terganggu", e);
            }
        });
    }
}

public class Latihan26 {
    public static void main(String[] args) {
        System.out.println("=== Sistem Pemesanan Pizza ===\n");
        
        // Membuat dapur pizza dengan 2 koki
        PizzaKitchen kitchen = new PizzaKitchen(2);

        // Membuat beberapa pesanan pizza
        PizzaOrder order1 = new PizzaOrder("Margherita");
        order1.addTopping("Mozzarella");
        order1.addTopping("Basil");
        order1.addTopping("Tomato Sauce");

        PizzaOrder order2 = new PizzaOrder("Pepperoni");
        order2.addTopping("Pepperoni");
        order2.addTopping("Mozzarella");
        order2.addTopping("Tomato Sauce");
        order2.addTopping("Oregano");

        // Memproses pesanan secara asynchronous
        CompletableFuture<Void> process1 = kitchen.preparePizza(order1)
            .thenCompose(PizzaDelivery::deliverPizza);

        CompletableFuture<Void> process2 = kitchen.preparePizza(order2)
            .thenCompose(PizzaDelivery::deliverPizza);

        // Menunggu semua pesanan selesai
        CompletableFuture.allOf(process1, process2).join();

        System.out.println("\nSemua pesanan telah selesai!");
        kitchen.shutdown();
    }
}
