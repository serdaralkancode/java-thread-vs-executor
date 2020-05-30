package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.joinExample;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Example {

    public static void main(String[] args) {

        CompletionStage<Void> cf =
                CompletableFuture.runAsync(() -> processLogic("first stage"));
        cf = cf.thenRun(() -> processLogic("second stage"));
        cf = cf.thenRunAsync(() -> processLogic("third stage"));
        ((CompletableFuture) cf).join();//waits until task is completed
        System.out.println("main exiting");

    }

    private static void processLogic(String stage) {

        System.out.println("---------");
        System.out.printf("stage: %s, time before task: %s, thread: %s%n",
                stage, LocalTime.now(), Thread.currentThread().getName());
        try {
            //simulating long task
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("stage: %s, time after task: %s, thread: %s%n",
                stage, LocalTime.now(), Thread.currentThread().getName());
    }

}
