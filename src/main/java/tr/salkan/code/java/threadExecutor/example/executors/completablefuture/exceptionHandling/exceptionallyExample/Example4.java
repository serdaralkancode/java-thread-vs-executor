package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.exceptionHandling.exceptionallyExample;

import java.util.concurrent.CompletableFuture;

public class Example4 {

    public static void main(String[] args) {

        runTasks(4);
        runTasks(0);

    }

    private static void runTasks(int i) {
        System.out.printf("-- input: %s --%n", i);
        CompletableFuture
                .supplyAsync(() -> {
                    return 16 / i;
                }).exceptionally(exception -> {
                            System.out.println("in exceptionally");
                            System.err.println(exception);
                            return 1;
                })
                .thenApply(input -> input * 2)
                .thenAccept(System.out::println);
    }
}
