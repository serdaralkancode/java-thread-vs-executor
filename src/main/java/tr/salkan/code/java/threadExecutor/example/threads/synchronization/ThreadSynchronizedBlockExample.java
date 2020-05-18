package tr.salkan.code.java.threadExecutor.example.threads.synchronization;

/* synchronized block */

public class ThreadSynchronizedBlockExample {

    public static int val1;
    public int val2;

    public static synchronized int test1Static() {
        val1++;
        return val1;
    }

    public static int test2Static() {
        synchronized (ThreadSynchronizedBlockExample.class) {
            val1++;
            return val1;
        }
    }

    public synchronized int test3Instance() {
        val2++;
        return val2;
    }

    public int test4Instance() {
        synchronized (this) {
            val2++;
            return val2;
        }
    }
}
