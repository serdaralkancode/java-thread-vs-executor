package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.exceptionHandling.exceptionallyExample;

import java.util.concurrent.CompletableFuture;

public class Example2 {

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<Void> completableFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("running task");
                    return 1 / 0;
                })
                .thenApply(input -> {
                    System.out.println("thenApply");
                    return input * 2;
                })
                .thenAccept(System.out::println);

        Thread.sleep(3000);//let the stages complete
        System.out.println("-- checking exceptions --");
        boolean b = completableFuture.isCompletedExceptionally();
        System.out.println("completedExceptionally: " + b);
        System.out.println("-- calling join --");
        completableFuture.join();

    }
}
