package tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.future.example2;

import tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.future.CallableObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExampleDone {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newSingleThreadExecutor();

        CallableObject callableObject = new CallableObject(8);

        Future<Integer> futureResult = es.submit(callableObject);

        System.out.println("callable submitted");

        while(!futureResult.isDone()) {
            //do some other stuff
            Thread.sleep(10);
        }

        System.out.println("task done");
        Integer result = futureResult.get();//will not block
        System.out.println(result);
        es.shutdown();

    }
}
