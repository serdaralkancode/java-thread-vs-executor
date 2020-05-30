package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenAcceptExample;

public class ExampleObject {

    private Integer number;

    public ExampleObject(Integer number) {
        this.number = number;
    }


    public Integer getFactorial() {

        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
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