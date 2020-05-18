package tr.salkan.code.java.threadExecutor.example.threads.waitnotify;

public class Example {

    public static void main(String[] args) {
        CountTotalThread countTotalThread = new CountTotalThread();
        countTotalThread.start();

        synchronized (countTotalThread) {
            try {
                System.out.println("Waiting for countTotalThread to complete");
                countTotalThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("total is: " + countTotalThread.total);
            System.out.println("counter is: " + countTotalThread.counter);
        }

    }
}

class CountTotalThread extends Thread {
    int total;
    int counter;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                total += i;
                counter = i;
            }
            notify();
        }
    }
}
