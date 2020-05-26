package tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.future.example1;

import tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.future.CallableObject;

import java.util.concurrent.*;

public class ExampleGet {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newSingleThreadExecutor();

        CallableObject callableObject = new CallableObject(7);

        Future<Integer> futureResult = es.submit(callableObject);

        System.out.println("callable submitted");
        //after doing other stuff
        System.out.println("waiting for result");
        Integer result = futureResult.get();//blocks until the task finishes
        System.out.println(result);
        es.shutdown();

    }
}
