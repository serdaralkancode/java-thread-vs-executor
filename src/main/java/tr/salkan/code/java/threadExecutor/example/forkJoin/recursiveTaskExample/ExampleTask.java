package tr.salkan.code.java.threadExecutor.example.forkJoin.recursiveTaskExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ExampleTask extends RecursiveTask<String> {

    private static final long serialVersionUID = 1L;

    private List<Double> salaries;

    public ExampleTask(List<Double> salaries) {
        this.salaries = salaries;
    }

    @Override
    protected String compute() {

        if(salaries.size() == 1)
        {
            return computeTaxAndGetSalary(salaries.get(0));
        }

        List<Double> oneSalary = salaries.subList(0, salaries.size()/2);
        List<Double> twoSalary = salaries.subList(salaries.size()/2,
                salaries.size());

        ExampleTask taskOne = new ExampleTask(oneSalary);
        taskOne.fork();

        ExampleTask taskTwo = new ExampleTask(twoSalary);

        return taskTwo.compute()+"," + taskOne.join();

    }

    String computeTaxAndGetSalary(Double salary) {

        Double taxRate = 1.0;

        if(salary < 2000)
        {
            taxRate = 7.5;
        }
        else if( salary >=2000 || salary < 5000)
        {
            taxRate = 12.5;
        }
        else if ( salary >= 5000)
        {
            taxRate = 20.5;
        }

        Double money = salary - ((salary*taxRate)/100);
        return "salary : " + salary + " taxRate :" + taxRate + " result : " + money;
    }

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        List<Double> salaryList = new ArrayList<Double>();
        salaryList.add(3000.0);
        salaryList.add(2000.0);
        salaryList.add(1800.0);
        salaryList.add(9000.0);

        ExampleTask exampleTask = new ExampleTask(salaryList);

        String coupons = forkJoinPool.invoke(exampleTask);
        System.out.println(coupons);

    }
}
