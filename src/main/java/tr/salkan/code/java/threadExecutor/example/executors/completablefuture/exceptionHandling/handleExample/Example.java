package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.exceptionHandling.handleExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Integer number = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if(number < 0) {
                throw new IllegalArgumentException("Can not be negative");
            }
            if(number > 50) {
                return "Bigger than 50";
            } else {
                return "Smaller than 50";
            }
        }).handle((res, ex) -> {
            if(ex != null) {
                System.out.println("To be exception - " + ex.getMessage());
                return "NOT!!";
            }
            return res;
        });

        System.out.println("Result : " + maturityFuture.get());

    }
}
