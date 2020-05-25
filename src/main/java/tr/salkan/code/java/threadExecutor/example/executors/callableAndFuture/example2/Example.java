package tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Example {

    public static void main(String[] args) {


        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<>();

        for (int i=5; i<10; i++)
        {
            CallableObject callableObject  = new CallableObject(i);
            Future<Integer> result = executor.submit(callableObject);
            resultList.add(result);
        }

        for(Future<Integer> future : resultList)
        {
            try
            {
                System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }


        executor.shutdown();
    }
}
