package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.runAsyncExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {

                // all code your bussiness

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println("CompletableFuturerunAsync runAsync .");
            }
        });

        // Block and wait for the future to complete

        System.out.println("future get result :" + future.get());   // return null

    }



}
