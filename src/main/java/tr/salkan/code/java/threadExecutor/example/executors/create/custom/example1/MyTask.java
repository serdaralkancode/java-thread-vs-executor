package tr.salkan.code.java.threadExecutor.example.executors.create.custom.example1;

public class MyTask implements Runnable {

    private final String taskName;
    private final Integer processCount;
    private Integer total;

    public MyTask(String taskName, Integer processCount) {
        super();
        this.taskName = taskName;
        this.processCount = processCount;
    }


    @Override
    public void run() {

        try
        {
            //System.out.println("Task name :  "+taskName+ " thread name :  "+Thread.currentThread().getName());

            total = 0;

            for(int i  = 1; i < processCount; i++)
            {
                total += i;
            }

            total = total*2;
            System.out.println("name : " + taskName + " total :" + total);

            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public Integer getTotal() {
        return total;
    }

    public String getTaskName() {
        return taskName;
    }
}
