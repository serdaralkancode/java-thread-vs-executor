package tr.salkan.code.java.threadExecutor.example.executors.create.cachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPoolExample3 {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(new CountingThread("A"));
        pool.execute(new CountingThread("B"));
        pool.execute(new CountingThread("C"));
        pool.execute(new CountingThread("D"));

        pool.shutdown();

    }

    /*
        OUTPUT:

                pool-1-thread-1 -> A: 5
                pool-1-thread-4 -> D: 5
                pool-1-thread-3 -> C: 5
                pool-1-thread-2 -> B: 5
                pool-1-thread-4 -> D: 4
                pool-1-thread-1 -> A: 4
                pool-1-thread-3 -> C: 4
                pool-1-thread-2 -> B: 4
                pool-1-thread-4 -> D: 3
                pool-1-thread-1 -> A: 3
                pool-1-thread-2 -> B: 3
                pool-1-thread-3 -> C: 3
                pool-1-thread-4 -> D: 2
                pool-1-thread-1 -> A: 2
                pool-1-thread-2 -> B: 2
                pool-1-thread-3 -> C: 2
                pool-1-thread-4 -> D: 1
                pool-1-thread-1 -> A: 1
                pool-1-thread-2 -> B: 1
                pool-1-thread-3 -> C: 1
                pool-1-thread-4 -> D: 0
                pool-1-thread-1 -> A: 0
                pool-1-thread-2 -> B: 0
                pool-1-thread-3 -> C: 0

     */
}
