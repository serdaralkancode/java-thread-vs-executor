package tr.salkan.code.java.threadExecutor.example.threads.priority;

import java.util.concurrent.TimeUnit;

public class ThreadPriorityExample {


    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.setName("thread 1");
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();

        Thread thread2 = new MyThread();
        thread2.setName("thread 2");
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.start();

    }

    private static class MyThread extends Thread {

        private int val;

        @Override
        public void run () {

            String threadName = Thread.currentThread()
                    .getName();

            System.out.println(threadName + " start.");
            for (int i = 0; i < 10; i++) {
                val++;
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("val value " + val);
            System.out.println(threadName + " end.");
        }
    }

}
