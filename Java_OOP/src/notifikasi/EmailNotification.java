package notifikasi;

public class EmailNotification implements interfaceNotifikasi {
    @Override
    public void sendMessage(String receiver, String content) {
        System.out.println("Mengirim email ke " + receiver + " dengan isi: " + content);
    }   
    
}
