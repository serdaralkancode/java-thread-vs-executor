package tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.future;

import java.util.concurrent.TimeUnit;

public class RunnableObject implements Runnable {

    private Integer number;

    public RunnableObject(Integer number) {
        this.number = number;
    }


    @Override
    public void run() {

        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Factorial result - " + number + " -> " + result);

    }
}
