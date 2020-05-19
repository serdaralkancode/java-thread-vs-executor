package tr.salkan.code.java.threadExecutor.example.executors.create.singleThreadExecutor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new CountingThread("A"));
        executorService.execute(new CountingThread("B"));
        executorService.execute(new CountingThread("C"));
        executorService.execute(new CountingThread("D"));

        executorService.shutdown();
    }

    /*
        pool-1-thread-1 -> A: 5
        pool-1-thread-1 -> A: 4
        pool-1-thread-1 -> A: 3
        pool-1-thread-1 -> A: 2
        pool-1-thread-1 -> A: 1
        pool-1-thread-1 -> A: 0
        pool-1-thread-1 -> B: 5
        pool-1-thread-1 -> B: 4
        pool-1-thread-1 -> B: 3
        pool-1-thread-1 -> B: 2
        pool-1-thread-1 -> B: 1
        pool-1-thread-1 -> B: 0
        pool-1-thread-1 -> C: 5
        pool-1-thread-1 -> C: 4
        pool-1-thread-1 -> C: 3
        pool-1-thread-1 -> C: 2
        pool-1-thread-1 -> C: 1
        pool-1-thread-1 -> C: 0
        pool-1-thread-1 -> D: 5
        pool-1-thread-1 -> D: 4
        pool-1-thread-1 -> D: 3
        pool-1-thread-1 -> D: 2
        pool-1-thread-1 -> D: 1
        pool-1-thread-1 -> D: 0
     */
}
