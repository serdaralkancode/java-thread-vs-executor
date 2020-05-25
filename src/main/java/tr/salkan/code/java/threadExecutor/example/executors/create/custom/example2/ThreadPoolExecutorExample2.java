package tr.salkan.code.java.threadExecutor.example.executors.create.custom.example2;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample2 {

    public static void main(String[] args) {


        //equivalent to Executors.newCachedThreadPool()
        ececuteTaskPool(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L,
                        TimeUnit.SECONDS,
                        new SynchronousQueue<>()),
                "equivalent to Executors#newCachedThreadPool()");

        //equivalent to Executors.newFixedThreadPool(int nThreads)
        ececuteTaskPool(new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>()),
                "equivalent to Executors#newFixedThreadPool(int nThreads)");


        //equivalent to Executors.newSingleThreadExecutor()
        ececuteTaskPool(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>()),
                "equivalent to Executors#newSingleThreadExecutor()");


    }

    private static void ececuteTaskPool (ThreadPoolExecutor e, String msg) {
        System.out.println("---- " + msg + "-------------");

        for (int i = 0; i < 10; i++) {
            try {
                e.execute(new MyTask());
            } catch (RejectedExecutionException ex) {
                System.out.println("Task rejected = " + (i + 1));
            }
            printTaskInfo(i + 1, e);
        }

        e.shutdownNow();

        System.out.println("--------------------\n");
    }

    private static class MyTask implements Runnable {

        @Override
        public void run () {
            while (true) {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }


    private static void printTaskInfo (int taskSubmitted, ThreadPoolExecutor e) {


        StringBuilder s = new StringBuilder();
        s.append("poolSize = ")
                .append(e.getPoolSize())
                .append(", corePoolSize = ")
                .append(e.getCorePoolSize())
                .append(", queueSize = ")
                .append(e.getQueue()
                        .size())
                .append(", queueRemainingCapacity = ")
                .append(e.getQueue()
                        .remainingCapacity())
                .append(", maximumPoolSize = ")
                .append(e.getMaximumPoolSize())
                .append(", totalTasksSubmitted = ")
                .append(taskSubmitted);

        System.out.println(s.toString());


    }

}



