package app;

public class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("MyThread2 is running - Iteration: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds (0.5 second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}