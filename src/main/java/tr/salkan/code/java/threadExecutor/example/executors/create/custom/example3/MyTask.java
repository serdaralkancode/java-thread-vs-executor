package tr.salkan.code.java.threadExecutor.example.executors.create.custom.example3;

public class MyTask implements Runnable {

    private String name = null;

    public MyTask(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing : " + name);
    }
}
