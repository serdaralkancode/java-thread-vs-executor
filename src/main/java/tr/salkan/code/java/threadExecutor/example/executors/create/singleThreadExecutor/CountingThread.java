package tr.salkan.code.java.threadExecutor.example.executors.create.singleThreadExecutor;

public class CountingThread extends Thread {
    private String clockName;

    public CountingThread(String clockName) {
        this.clockName = clockName;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = 5; i >= 0; i--) {

            System.out.printf("%s -> %s: %d\n", threadName, clockName, i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
