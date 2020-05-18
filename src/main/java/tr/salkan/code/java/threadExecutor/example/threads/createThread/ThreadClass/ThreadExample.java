package tr.salkan.code.java.threadExecutor.example.threads.createThread.ThreadClass;

public class ThreadExample extends Thread {

    @Override
    public void run() {

        System.out.println("Inside thread name : " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        System.out.println("Thread name  : " + Thread.currentThread().getName());  // main thread

        System.out.println("Creating thread");

        Thread thread = new ThreadExample();

        System.out.println("Starting thread");

        thread.start();
    }
}
