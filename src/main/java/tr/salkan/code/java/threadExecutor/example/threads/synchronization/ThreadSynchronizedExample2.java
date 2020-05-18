package tr.salkan.code.java.threadExecutor.example.threads.synchronization;

public class ThreadSynchronizedExample2 implements Runnable {


    @Override
    public void run() {
        increment();
        decrement();
    }

    static int val = 0;

    public static synchronized void increment() {
        val++;
    }

    public static synchronized void decrement() {
        val--;
    }

    public static int value() {
        return val;
    }

    public static void main(String[] args) {

        ThreadSynchronizedExample2 example2 = new ThreadSynchronizedExample2();

        Thread t1 = new Thread(example2);
        Thread t2 = new Thread(example2);

        t1.start();
        t2.start();

        System.out.println(example2.val);

    }
}
