package tr.salkan.code.java.threadExecutor.example.threads.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Example {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(4);

        ThreadExample first = new ThreadExample(1000, latch,
                "ThreadExample-1");
        ThreadExample second = new ThreadExample(2000, latch,
                "ThreadExample-2");
        ThreadExample third = new ThreadExample(3000, latch,
                "ThreadExample-3");
        ThreadExample fourth = new ThreadExample(4000, latch,
                "ThreadExample-4");

        fourth.start();
        third.start();
        second.start();
        first.start();

        latch.await();

        System.out.println(Thread.currentThread().getName() +
                " has finished");
    }
}

class ThreadExample extends Thread
{
    private int delay;
    private CountDownLatch latch;

    public ThreadExample(int delay, CountDownLatch latch,
                  String name)
    {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()
                    + " finished");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
