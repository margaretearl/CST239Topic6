package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.start("localhost", 6666);
            for (int i = 1; i <= 9; i++) {
                String message = "Message " + i;
                String response = client.sendMessage(message);
                System.out.println("Sent: " + message);
                System.out.println("Response: " + response);
            }
            client.sendMessage("."); // Send quit message
            client.cleanup(); // Cleanup and exit
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(String ipAddress, int port) throws IOException {
        socket = new Socket(ipAddress, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public String sendMessage(String message) throws IOException {
        out.println(message);
        return in.readLine();
    }

    public void cleanup() throws IOException {
        // Close all network buffers and sockets
        if (out != null) out.close();
        if (in != null) in.close();
        if (socket != null) socket.close();
    }
}
