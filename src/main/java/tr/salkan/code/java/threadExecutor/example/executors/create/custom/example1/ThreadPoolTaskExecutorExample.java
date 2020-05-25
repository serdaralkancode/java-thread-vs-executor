package tr.salkan.code.java.threadExecutor.example.executors.create.custom.example1;

import java.util.concurrent.*;

public class ThreadPoolTaskExecutorExample {

    public static void main(String[] args) {

        // Queue capacity => 4
        BlockingQueue queue=new ArrayBlockingQueue(4);

        ThreadFactory threadFactory= Executors.defaultThreadFactory();

        MyRejectTaskHandler rth=new MyRejectTaskHandler();

        /*
                corePoolsize : 1
                maximumPoolsize : 2

                send 10 task

                task can not read 4 task

         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10L, TimeUnit.MILLISECONDS, queue,
                threadFactory,rth);


        for(int i = 10; i < 20; i++)
        {
            MyTask myTask = new MyTask("task_"+i,i);

            System.out.println("task name : " + myTask.getTaskName());

            threadPoolExecutor.execute(myTask);
        }

        threadPoolExecutor.shutdown();

    }

}
