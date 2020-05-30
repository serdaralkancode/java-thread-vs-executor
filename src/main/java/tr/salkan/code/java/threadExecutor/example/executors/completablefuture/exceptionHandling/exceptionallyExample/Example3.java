package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.exceptionHandling.exceptionallyExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFuture<Integer> completableFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("running task");
                    return 10 / 0;
                }).exceptionally(exception -> {
                    System.err.println("exception: " + exception);
                    return 1;
                });
        Thread.sleep(3000);//let the stages complete
        System.out.println("-- checking exceptions --");
        boolean b = completableFuture.isCompletedExceptionally();
        System.out.println("completedExceptionally: " + b);
        System.out.println("-- getting results --");
        int result = completableFuture.get();
        System.out.println(result);

    }
}
