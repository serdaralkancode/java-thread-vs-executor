package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenApplyExample;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExampleObject implements Callable<Integer> {

    private Integer number;

    public ExampleObject(Integer number) {
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

        return result;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}