package tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        CallableObject callableObject = new CallableObject(20);

        //get future object
        Future<Integer> future = executor.submit(callableObject);

        try {
            while(!future.isDone()) {
                Thread.sleep(20);
            }

            Integer result = future.get();
            System.out.println("result from callable "+result);
        }catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
