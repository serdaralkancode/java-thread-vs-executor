package tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableObject implements Callable<Integer> {

    private Integer number;

    public CallableObject(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {

        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.println("Factorial result - " + number + " -> " + result);
        return result;
    }
}
