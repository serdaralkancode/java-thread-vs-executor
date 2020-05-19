package tr.salkan.code.java.threadExecutor.example.executors.create.cachedThreadPool;

import java.util.concurrent.*;

/*
        creates an expandable thread pool executor.
        New threads are created as needed, and previously constructed threads are reused when they are available.
        Idle threads are kept in the pool for one minute.
        This executor is suitable for applications that launch many short-lived concurrent tasks.
 */

public class NewCachedThreadPoolExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //creates cached thread pool
        ExecutorService exService = Executors.newCachedThreadPool();
        // runnable thread start to execute.
        exService.execute(new NewCachedThreadPoolExample().new RunnableThread());
        //callable thread starts to execute
        Future<Integer> future=exService.submit(new NewCachedThreadPoolExample().new CallableThread());
        //gets value of callable thread
        int val=future.get();
        System.out.println(val);
        //checks for thread termination
        boolean isTerminated=exService.isTerminated();
        System.out.println(isTerminated);
        // waits for termination for 30 seconds only
        exService.awaitTermination(30, TimeUnit.SECONDS);
        exService.shutdownNow();

    }

    //Callable thread
    class CallableThread implements Callable<Integer> {
        @Override
        public Integer call() {
            int cnt = 0;
            for (; cnt < 5; cnt++) {
                System.out.println("CallableThread call :" + cnt);
            }
            return cnt;
        }
    }
    //Runnable thread
    class RunnableThread implements Runnable {
        @Override
        public void run() {
            int cnt = 0;
            for (; cnt < 5; cnt++) {
                System.out.println("RunnableThread run :" + cnt);
            }
        }
    }


}
