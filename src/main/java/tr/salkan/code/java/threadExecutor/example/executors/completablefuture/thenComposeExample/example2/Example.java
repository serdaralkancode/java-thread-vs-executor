package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenComposeExample.example2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Helper1 helper1 = new Helper1();
        Helper2 helper2 = new Helper2();

        Double salary = 6570.65;

        System.out.println("salary : " + salary);

        CompletableFuture<Double> taxRateF = CompletableFuture.supplyAsync(() -> {

            return helper1.getTaxRate();
        });

        CompletableFuture<Double> stoppageF = CompletableFuture.supplyAsync(() -> {

            return helper2.getStoppage(salary);
        });

        CompletableFuture<Double> combineF = taxRateF
                .thenCombine(stoppageF, (t, s) -> {
                    Double tax = (salary*t)/100 ;
                    return salary - (tax + s);
                });

        System.out.println("after tax salary -> " + combineF.get());

    }
}
