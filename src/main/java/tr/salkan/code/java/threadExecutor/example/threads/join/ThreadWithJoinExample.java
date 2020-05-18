package tr.salkan.code.java.threadExecutor.example.threads.join;

public class ThreadWithJoinExample implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread name:" + Thread.currentThread().getName() + " index:" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadWithJoinExample runnable = new ThreadWithJoinExample();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.setName("myThread1");
        thread2.setName("myThread2");
        thread3.setName("myThread3");

        thread1.start();
        thread1.join();  // until thread1's over, not start any thread (thread2,thread3)


        thread2.start();

        thread2.join();  // // until thread2's over, not start any thread (thread3)


        thread3.start();

    }


}
