package app;

public class CounterWorker {
    public static void main(String[] args) {
        System.out.println("Initial Counter Value: " + Counter.getCount());

        CounterThread[] counterThreads = new CounterThread[1000];

        for (int i = 0; i < counterThreads.length; i++) {
            counterThreads[i] = new CounterThread();
            counterThreads[i].start();
        }

        for (CounterThread counterThread : counterThreads) {
            try {
                counterThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final Counter Value: " + Counter.getCount());
    }
}