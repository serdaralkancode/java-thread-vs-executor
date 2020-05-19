package tr.salkan.code.java.threadExecutor.example.executors.create.singleThreadExecutor;

import java.util.concurrent.*;

public class SingleThreadCallableExample {

    public static void main(String[] args) {

        System.out.println("Main thread : " + Thread.currentThread().getName());

        System.out.println("Create ExecutorService newSingleThreadExecutor");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("Creating a Callable...");

        Callable<Integer> task = new Callable<Integer>() {
            public Integer call() {

                int toplam = 20;
                for(int i = 0; i <=10; i++)
                {
                    System.out.println("callable i : " + i);
                    toplam +=i;
                }

                return toplam;
            }
        };

        Future<Integer> result = executorService.submit(task);

        try {

            Integer returnValue = result.get();

            System.out.println("Return value = " + returnValue);

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

        executorService.shutdown();


    }
}
