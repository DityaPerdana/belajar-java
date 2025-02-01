package com.belajar;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;

class Message {
    private String sender;
    private String content;
    private long timestamp;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    public String getSender() { return sender; }
    public String getContent() { return content; }
    public long getTimestamp() { return timestamp; }
}

class ChatRoom {
    private String nama;
    private List<Message> messages;
    private Set<String> participants;
    private List<Consumer<Message>> messageListeners;

    public ChatRoom(String nama) {
        this.nama = nama;
        this.messages = Collections.synchronizedList(new ArrayList<>());
        this.participants = Collections.synchronizedSet(new HashSet<>());
        this.messageListeners = new ArrayList<>();
    }

    public void addParticipant(String username) {
        participants.add(username);
        broadcastSystemMessage(username + " bergabung ke chat room");
    }

    public void removeParticipant(String username) {
        participants.remove(username);
        broadcastSystemMessage(username + " meninggalkan chat room");
    }

    public void addMessageListener(Consumer<Message> listener) {
        messageListeners.add(listener);
    }

    public void sendMessage(String sender, String content) {
        if (!participants.contains(sender)) {
            System.out.println("Error: Pengirim tidak ada dalam chat room");
            return;
        }

        Message message = new Message(sender, content);
        messages.add(message);
        notifyListeners(message);
    }

    private void broadcastSystemMessage(String content) {
        Message message = new Message("SYSTEM", content);
        messages.add(message);
        notifyListeners(message);
    }

    private void notifyListeners(Message message) {
        messageListeners.forEach(listener -> listener.accept(message));
    }

    public String getNama() { return nama; }
    public List<Message> getMessages() { return new ArrayList<>(messages); }
    public Set<String> getParticipants() { return new HashSet<>(participants); }
}

class ChatClient implements Runnable {
    private String username;
    private ChatRoom chatRoom;
    private Scanner scanner;
    private volatile boolean running;

    public ChatClient(String username, ChatRoom chatRoom) {
        this.username = username;
        this.chatRoom = chatRoom;
        this.scanner = new Scanner(System.in);
        this.running = true;

        // Menambahkan listener untuk menampilkan pesan
        chatRoom.addMessageListener(this::displayMessage);
    }

    private void displayMessage(Message message) {
        String timestamp = new java.text.SimpleDateFormat("HH:mm:ss")
            .format(new Date(message.getTimestamp()));
        
        if (message.getSender().equals("SYSTEM")) {
            System.out.printf("[%s] %s\n", 
                timestamp, message.getContent());
        } else {
            System.out.printf("[%s] %s: %s\n", 
                timestamp, message.getSender(), message.getContent());
        }
    }

    @Override
    public void run() {
        chatRoom.addParticipant(username);
        
        while (running) {
            String message = scanner.nextLine();
            
            if (message.equalsIgnoreCase("/quit")) {
                running = false;
                break;
            } else if (message.equalsIgnoreCase("/participants")) {
                showParticipants();
            } else if (!message.trim().isEmpty()) {
                chatRoom.sendMessage(username, message);
            }
        }

        chatRoom.removeParticipant(username);
    }

    private void showParticipants() {
        System.out.println("\nPeserta dalam " + chatRoom.getNama() + ":");
        chatRoom.getParticipants().forEach(p -> 
            System.out.println("- " + p)
        );
        System.out.println();
    }

    public void stop() {
        running = false;
    }
}

class ChatSimulator {
    private ChatRoom chatRoom;
    private List<ChatClient> clients;
    private ExecutorService executor;

    public ChatSimulator() {
        this.chatRoom = new ChatRoom("Java Chat Room");
        this.clients = new ArrayList<>();
        this.executor = Executors.newCachedThreadPool();
    }

    public void addClient(String username) {
        ChatClient client = new ChatClient(username, chatRoom);
        clients.add(client);
        executor.submit(client);
    }

    public void simulateChat() {
        // Simulasi beberapa pesan otomatis
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        String[] simulatedUsers = {"Bot1", "Bot2", "Bot3"};
        String[] simulatedMessages = {
            "Halo semua!",
            "Apa kabar?",
            "Selamat pagi!",
            "Sedang belajar Java nih",
            "Java memang menyenangkan"
        };

        Random random = new Random();

        // Menambahkan bot ke chat room
        for (String user : simulatedUsers) {
            chatRoom.addParticipant(user);
        }

        // Menjadwalkan pengiriman pesan acak
        scheduler.scheduleAtFixedRate(() -> {
            String user = simulatedUsers[random.nextInt(simulatedUsers.length)];
            String message = simulatedMessages[random.nextInt(simulatedMessages.length)];
            chatRoom.sendMessage(user, message);
        }, 1, 3, TimeUnit.SECONDS);

        // Menghentikan simulator setelah beberapa waktu
        scheduler.schedule(() -> {
            scheduler.shutdown();
            for (String user : simulatedUsers) {
                chatRoom.removeParticipant(user);
            }
        }, 30, TimeUnit.SECONDS);
    }

    public void shutdown() {
        clients.forEach(ChatClient::stop);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

public class Latihan30 {
    public static void main(String[] args) {
        System.out.println("=== Java Chat Room Simulator ===");
        System.out.println("Perintah yang tersedia:");
        System.out.println("/participants - Menampilkan daftar peserta");
        System.out.println("/quit - Keluar dari chat room");
        System.out.println("----------------------------------------");

        ChatSimulator simulator = new ChatSimulator();
        
        // Memulai simulasi chat dengan bot
        simulator.simulateChat();

        // Menambahkan pengguna manusia
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan username Anda: ");
        String username = scanner.nextLine();
        
        simulator.addClient(username);

        // Program akan berjalan sampai semua client selesai
        Runtime.getRuntime().addShutdownHook(new Thread(simulator::shutdown));
    }
}
