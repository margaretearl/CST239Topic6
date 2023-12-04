package app;

import java.io.IOException;

public class ServerThread extends Thread {
    @Override
    public void run() {
        Server server = new Server();
        try {
            server.start(6666);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.cleanup();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
