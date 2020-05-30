package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenApplyExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExampleObject exampleObject = new ExampleObject(6);

        // Create a CompletableFuture
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                return exampleObject.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        });

        CompletableFuture<String> greetingFuture = future.thenApply(num -> {

            return num + " is factorial of ";
        }).thenApply(str -> {

            return str + exampleObject.getNumber();
        });

        // Block and get the result of the future.
        System.out.println(greetingFuture.get());

    }
}
