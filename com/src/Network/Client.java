package Network;
import java.net.DatagramSocket;

public class Client {
    private DatagramSocket socket;

    public Client() {
        try {
            socket = new DatagramSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
