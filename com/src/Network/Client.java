package Network;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class Client implements User {
    private Socket socket;
    private String hostname;
    private DataInputStream reader;
    private DataOutputStream writer;

    public Client(String hostname) {
        this.hostname = hostname;
        try {
            socket = new Socket(hostname, 12345);
            reader = new DataInputStream(socket.getInputStream());
            writer = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(byte[] data) throws IOException, UnsupportedEncodingException {
        for(byte b : data) {
            writer.write(b);
        }
        writer.flush();
    }

    //expecting to "joker" the stream
    public byte[] receive() throws IOException {
        if (socket == null || socket.isClosed()) {
            System.out.println("Socket is not connected.");
            return new byte[0];
        }
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int read;
        while((read = reader.read()) != -1) {
            buffer.write(read);
        }

        return buffer.toByteArray();
    }
}
