package tr.salkan.code.java.threadExecutor.example.executors.create.singleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    creates an executor that executes a single task at a time.
    Submitted tasks are guaranteed to execute sequentially, and no more than one task will be active at any time.
    Consider using this executor if you want to queue tasks to be executed in order, one after another.

 */

public class SingleThreadRunnableExample {

    public static void main(String[] args) {

        System.out.println("Main thread : " + Thread.currentThread().getName());

        System.out.println("Create ExecutorService newSingleThreadExecutor");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("Creating a Runnable...");
        Runnable runnable = () -> {

            for(int i = 0; i <=10; i++)
            {
                System.out.println("runnable i : " + i);
            }

        };

        System.out.println("Submit the task specified by the runnable to the executor service.");

        // executorService.execute(runnable);  if you want to use execute function
        executorService.submit(runnable);

        executorService.shutdown();  // if you want to use -> to destroy the executor after the thread completes execution

    }
}
