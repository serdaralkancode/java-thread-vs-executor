package tr.salkan.code.java.threadExecutor.example.executors.create.custom.example1;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejectTaskHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        MyTask myTask=(MyTask) r;
        System.out.println("Task can not read  :"+((MyTask) r).getTaskName());
    }
}
