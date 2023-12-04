package app;

public class ServerApp {
    public static void main(String[] args) {
        ServerThread serverThread = new ServerThread();
        serverThread.start();

        while (serverThread.isAlive()) {
            System.out.print(".");
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ServerThread has terminated.");
    }
}
