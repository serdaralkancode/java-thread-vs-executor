package tr.salkan.code.java.threadExecutor.example.threads.createThread.RunnableInterface;

public class RunnableExample2 {

    public static void main(String[] args) {

        MyThreadRunner threadRunnable = new MyThreadRunner();
        Thread thread = new Thread(threadRunnable);
        thread.start();

        MyThreadRunner threadRunnable2 = new MyThreadRunner();
        Thread thread2 = new Thread(threadRunnable2);
        thread2.start();

        System.out.println(Thread.currentThread()
                .getName());


    }

    private static class MyThreadRunner implements Runnable {
        @Override
        public void run () {

            System.out.println("MyThread name : " + Thread.currentThread().getName());
        }
    }
}
