package notifikasi;

public class PushNotification implements interfaceNotifikasi {
    @Override
    public void sendMessage(String receiver, String content) {
        System.out.println("Mengirim push notification ke " + receiver + " dengan isi: " + content);
    }
    
}
