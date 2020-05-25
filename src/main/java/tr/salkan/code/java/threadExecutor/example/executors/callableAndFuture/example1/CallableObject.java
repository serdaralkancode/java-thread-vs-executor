package tr.salkan.code.java.threadExecutor.example.executors.callableAndFuture.example1;

import java.util.concurrent.Callable;

public class CallableObject implements Callable<Integer> {

    private Integer enteredInt;

    public CallableObject(Integer enteredInt) {
        this.enteredInt = enteredInt;
    }

    @Override
    public Integer call() throws Exception {

        int toplam = 0;

        for(int i = 0; i <= enteredInt; i++)
        {
            toplam +=i;
        }

        return toplam;
    }


}
