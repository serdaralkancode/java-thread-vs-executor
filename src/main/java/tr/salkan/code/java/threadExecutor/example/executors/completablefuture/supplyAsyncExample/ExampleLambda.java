package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.supplyAsyncExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ExampleLambda {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation lambda";
        });

        // Block and get the result of the Future
        String result = future.get();
        System.out.println(result);

    }
}
