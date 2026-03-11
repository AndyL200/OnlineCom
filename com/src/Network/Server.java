package Network;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;


public class Server implements User {
    ServerSocket server;
    ExecutorService pool = Executors.newFixedThreadPool(50);
    List<Socket> clients = new ArrayList<Socket>(0);
    Deque<byte[]> messages = new java.util.LinkedList<byte[]>();
    private final Semaphore messageSemaphore = new Semaphore(0);
    private class ClientHandler implements Callable<Void> {
        Socket client;
        ClientHandler(Socket client) {
            //handle client connection
            this.client = client;
        }
        public Void call() throws InterruptedException, IOException{
            //handle client connection
            DataInputStream reception = new DataInputStream(client.getInputStream());
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int read;
            while((read = reception.read()) != -1) {
                buffer.write(read);
            }
            byte[] message = buffer.toByteArray();
            //add message to queue for broadcasting
            messageSemaphore.acquire();
                messages.add(message);
            messageSemaphore.release();
            return null;
        }
    }
    private class MessageHandler implements Callable<Void> {
        MessageHandler() {
            //handle message broadcasting
        }
        public Void call() {
            //handle message broadcasting
            return null;
        }
    }

    public Server() {
        try {
            this.server = new ServerSocket(12345);
            while(true) {
                Socket client = server.accept();
                clients.add(client);
                pool.submit(new ClientHandler(client));
                sendBoard(client, new byte[0]); //send entire javafx scene tree on connect
                //can I leverage this against what the client already has stored?
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            pool.shutdown();
            if(server != null && !server.isClosed()) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void broadcast(byte[] message) {
        for(Socket client : clients) {
            //send message to client
            
        }
    }
    public void process() {

    }
    public void sendBoard(Socket client, byte[] Board) {

    }
}
