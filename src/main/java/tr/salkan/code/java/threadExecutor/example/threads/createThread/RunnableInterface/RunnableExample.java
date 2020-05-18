package tr.salkan.code.java.threadExecutor.example.threads.createThread.RunnableInterface;

public class RunnableExample implements Runnable {

    @Override
    public void run() {

        System.out.println("Inside thread name : " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {


        System.out.println("Thread name : " + Thread.currentThread().getName());

        System.out.println("Creating thread");
        Runnable runnable = new RunnableExample();

        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);

        System.out.println("Starting Thread");
        thread.start();


    }
}
