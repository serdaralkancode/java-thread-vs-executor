package tr.salkan.code.java.threadExecutor.example.threads.join;

public class ThreadWithOutJoinExample implements Runnable {


    //without join
    // Look output

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Thread name:" + Thread.currentThread().getName() + " index:" + i);
        }
    }

    public static void main(String[] args) {

        ThreadWithOutJoinExample runnable = new ThreadWithOutJoinExample();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.setName("myThread1");
        thread2.setName("myThread2");
        thread3.setName("myThread3");

        thread1.start();
        thread2.start();
        thread3.start();

    }



}
