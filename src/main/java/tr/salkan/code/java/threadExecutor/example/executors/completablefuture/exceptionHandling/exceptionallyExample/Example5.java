package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.exceptionHandling.exceptionallyExample;

import java.util.concurrent.CompletableFuture;

public class Example5 {

    public static void main(String[] args) {

        runTasks(2);
        runTasks(0);
    }

    private static void runTasks(int i) {
        System.out.printf("-- input: %s --%n", i);
        CompletableFuture.supplyAsync(() -> 16 / i)
                .thenApply(input -> input + 1)
                .thenApply(input -> input + 3)
                .exceptionally(exception -> {
                    System.out.println("in exceptionally");
                    System.err.println(exception);
                    return 1;
                })
                .thenApply(input -> input * 3)
                .thenAccept(System.out::println);
    }
}
