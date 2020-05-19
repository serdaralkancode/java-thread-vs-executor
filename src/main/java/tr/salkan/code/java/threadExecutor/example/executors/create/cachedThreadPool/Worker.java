package tr.salkan.code.java.threadExecutor.example.executors.create.cachedThreadPool;

import java.util.concurrent.Callable;

public class Worker implements Callable<ThreadObjectInfo> {
    private String workerName;

    public Worker(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public ThreadObjectInfo call() throws Exception {
        Thread.sleep(10);
        ThreadObjectInfo threadObjectInfo = new ThreadObjectInfo();
        threadObjectInfo.setWorkerName(workerName);
        threadObjectInfo.setThreadName(Thread.currentThread().getName());
        return threadObjectInfo;
    }
}
