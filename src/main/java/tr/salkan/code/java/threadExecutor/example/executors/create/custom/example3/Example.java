package tr.salkan.code.java.threadExecutor.example.executors.create.custom.example3;

import java.util.concurrent.*;

public class Example {

    public static void main(String[] args) {

        Integer threadCounter = 0;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);

        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10,
                20, 5000, TimeUnit.MILLISECONDS, blockingQueue);

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r,
                                          ThreadPoolExecutor executor) {
                System.out.println("MyTask Rejected : "
                        + ((MyTask) r).getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Add myTask name  : "
                        + ((MyTask) r).getName());
                executor.execute(r);
            }
        });

        executor.prestartAllCoreThreads();
        while (true) {
            threadCounter++;

            System.out.println("Add MyTask : " + threadCounter);
            executor.execute(new MyTask(threadCounter.toString()));

            if (threadCounter == 100)
                break;
        }

    }
}
