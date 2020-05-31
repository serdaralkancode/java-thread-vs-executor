package tr.salkan.code.java.threadExecutor.example.threads.cyclicBarrier;

public class CyclicBarrierFinishEvent implements Runnable{

    public void run() {

        System.out.println("As 3 threads have reached common barrier point "
                + ", CyclicBarrrierFinishEvent has been triggered");
        System.out.println("You can update shared variables if any");
    }

}
