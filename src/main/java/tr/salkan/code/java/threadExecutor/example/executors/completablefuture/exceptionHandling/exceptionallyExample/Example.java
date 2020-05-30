package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.exceptionHandling.exceptionallyExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int number = -1;

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            if(number < 0) {
                throw new IllegalArgumentException("Number can not be negative");
            }
            if(number > 50) {
                return "Bigger than 50";
            } else {
                return "Smaller than 50";
            }
        }).exceptionally(ex -> {
            System.out.println("Be exception - " + ex.getMessage());
            return "NOT!";
        });

        System.out.println("Number result : " + future1.get());

    }



}
