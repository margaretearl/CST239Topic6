package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start(12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("Client connected");

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Received from Client: " + inputLine);

                        if (inputLine.equals(".")) {
                            out.println("QUIT");
                            cleanup(); // Call cleanup before breaking out of the loop
                            break;
                        } else {
                            out.println("OK");
                        }
                    }

                    System.out.println("Client disconnected");
                }
            }
        }
    }

    public void cleanup() throws IOException {
    }
}
