package app;

public class TestMyThreads {
    public static void main(String[] args) {
        
        MyThread1 thread1 = new MyThread1();
        thread1.start();

  
        MyThread2 myThread2 = new MyThread2();
        Runnable myThread2Runnable = myThread2;

        Thread thread2 = new Thread(myThread2Runnable);
        thread2.start();
    }
}