package tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.future.example3;

import tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.future.RunnableObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExampleNoResult {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newSingleThreadExecutor();

        RunnableObject runnableObject = new RunnableObject(6);

        Future<?> futureResult = es.submit(runnableObject);


        System.out.println("runnable suabmitted");

        System.out.println("getting result");
        Object o = futureResult.get();
        System.out.println(o);
        es.shutdown();


    }

}
