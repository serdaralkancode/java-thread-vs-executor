package tr.salkan.code.java.threadExecutor.example.threads.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Example {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier=new CyclicBarrier(3 ,new CyclicBarrierFinishEvent());

        RunnableTaskExample runnableTask1=new RunnableTaskExample(cyclicBarrier,1000);
        RunnableTaskExample runnableTask2=new RunnableTaskExample(cyclicBarrier,2000);
        RunnableTaskExample runnableTask3=new RunnableTaskExample(cyclicBarrier,3000);


        //Create and start 3 threads
        new Thread(runnableTask1,"Thread-1").start();
        new Thread(runnableTask2,"Thread-2").start();
        new Thread(runnableTask3,"Thread-3").start();

        /*
         * We are reusing cyclic barrier using below threads
         * */
        RunnableTaskExample runnableTask4=new RunnableTaskExample(cyclicBarrier,4000);
        RunnableTaskExample runnableTask5=new RunnableTaskExample(cyclicBarrier,5000);
        RunnableTaskExample runnableTask6=new RunnableTaskExample(cyclicBarrier,6000);

        // Create and start 3 more threads
        new Thread(runnableTask4,"Thread-4").start();
        new Thread(runnableTask5,"Thread-5").start();
        new Thread(runnableTask6,"Thread-6").start();


    }
}

