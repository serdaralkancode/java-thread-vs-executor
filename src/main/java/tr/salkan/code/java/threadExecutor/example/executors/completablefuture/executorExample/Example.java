package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.executorExample;

import java.util.concurrent.*;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Executor executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "CompletableFuture supplyAsync with executor ";
        }, executor);

        System.out.println("result : " + future.get());

    }
}
