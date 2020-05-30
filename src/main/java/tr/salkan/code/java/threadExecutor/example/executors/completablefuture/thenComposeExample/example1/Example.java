package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenComposeExample.example1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ServiceExample serviceExample = new ServiceExample();
        ServiceExample2 serviceExample2 = new ServiceExample2(15);

        CompletableFuture<Double> future =
                CompletableFuture.supplyAsync(() -> serviceExample.getById(1l))
                        .thenCompose(entityExample -> CompletableFuture.supplyAsync(() -> serviceExample2.increaseSalary(entityExample)));


        System.out.println("increase salary " + future.get());


    }

}
