package tr.salkan.code.java.threadExecutor.example.forkJoin.recursiveActionExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ExampleTask extends RecursiveAction {

    private static final long serialVersionUID = 1L;

    private List<Integer> numberList;

    public ExampleTask(List<Integer> numberList) {
        this.numberList = numberList;
    }


    @Override
    protected void compute() {

        System.out.println("numberList :" + numberList);
        if(numberList != null && numberList.size() > 1) {
            List<Integer> oneNum = new ArrayList<Integer>();
            oneNum.add(numberList.remove(numberList.size()-1));

            ExampleTask subTaskOne = new ExampleTask(oneNum);
            ExampleTask subTaskTwo = new ExampleTask(numberList);

            invokeAll(subTaskOne, subTaskTwo);

        }else {

            computeFact(numberList.get(0));
        }

    }

    void computeFact(int num) {

        System.out.println("computeFact :" + num);

        int fact = 1;

        for(int i = 1; i <=num; i++)
        {
            fact = fact * i;
        }


        System.out.println("Thread "+Thread.currentThread().getId()
                +" Number "+num
                +"factorial "+fact);
    }

    public static void main(String[] args) {

        ForkJoinPool fjp = new ForkJoinPool();

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(11);
        list.add(3);

        ExampleTask exampleTask = new ExampleTask(list);

        fjp.invoke(exampleTask);

        //or using

        //fjp.execute(exampleTask);
        // exampleTask.join();
    }
}
