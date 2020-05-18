package tr.salkan.code.java.threadExecutor.example.threads.synchronization;

public class ThreadSynchronizedEample {

    private Integer value = 0;

    public static void main(String[] args) {

        ThreadSynchronizedEample demo = new ThreadSynchronizedEample();
        MyThread task1 = demo.new MyThread();
        Thread thread1 = new Thread(task1);

        MyThread task2 = demo.new MyThread();
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

    }

    private class MyThread implements Runnable {

        @Override
        public void run () {
            for (int i = 0; i < 5; i++) {
                processValue();
            }
        }
    }

    private synchronized void processValue () {
        int temp = value;
        value++;                                                                    // } ->  Race condition
        System.out.println(Thread.currentThread()
                .getName() + " - before: "+temp+" after:" + value);
    }
}
