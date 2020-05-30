package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.exceptionHandling.exceptionallyExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example6AllOf {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> f1 =  CompletableFuture
                .supplyAsync(() -> {
                    return 16 / 2;
                }).exceptionally(exception -> {
            System.out.println("in exceptionally");
            System.err.println(exception);
            return 1;
        });

        CompletableFuture<Integer> f2 =  CompletableFuture
                .supplyAsync(() -> {
                    return 16 / 0;
                }).exceptionally(exception -> {
                    System.out.println("in exceptionally");
                    System.err.println(exception);
                    return 1;
                });

        CompletableFuture<Integer> f3 =  CompletableFuture
                .supplyAsync(() -> {
                    return 16 / 4;
                }).exceptionally(exception -> {
                    System.out.println("in exceptionally");
                    System.err.println(exception);
                    return 1;
                });


        CompletableFuture<Void> allInfoFuture = CompletableFuture.allOf(f1, f2,f3);

        System.out.println("result : f1 : " + f1.get() + " f2: " + f2.get() + " f3 :" + f3.get());

    }

}
