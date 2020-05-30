package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenComposeExample.example2;

public class Helper2 {

    public Double getStoppage(Double salary)
    {
        if(salary < 1000)
        {
            return 200.12;
        }
        else
        {
            return 350.45;
        }
    }
}
