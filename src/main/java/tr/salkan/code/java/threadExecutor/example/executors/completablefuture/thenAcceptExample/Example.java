package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenAcceptExample;

import java.util.concurrent.CompletableFuture;

public class Example {

    public static void main(String[] args) {

        ExampleObject exampleObject = new ExampleObject(8);

        CompletableFuture<Void> parentComStage = CompletableFuture.supplyAsync(() -> {
            Integer result = 0;
            result = exampleObject.getFactorial();
            return result;
        }).thenAccept( resultOfPreviousStage -> {
            System.out.print("Result is : "+resultOfPreviousStage);
        });

    }
}
