package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.runAsyncExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ExampleLambda {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Simulate a long-running Job
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("CompletableFuturerunAsync runAsync lambda");
        });

        System.out.println("future get result :" + future.get());   // return null

    }
}
