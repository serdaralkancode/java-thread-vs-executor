package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.exceptionHandling.handleExample;

import java.util.concurrent.CompletableFuture;

public class Example2 {

    public static void main(String[] args) {

        runTasks(8);
        runTasks(0);
    }

    private static void runTasks(int i) {
        System.out.printf("-- input: %s --%n", i);
        CompletableFuture
                .supplyAsync(() -> {
                    return 16 / i;
                }).handle((input, exception) -> {
            if (exception != null) {
                System.out.println("exception block");
                System.err.println(exception);
                return 1;
            } else {

                return input + 2;
            }})
                .thenApply(input -> input * 3)
                .thenAccept(System.out::println);
    }
}
