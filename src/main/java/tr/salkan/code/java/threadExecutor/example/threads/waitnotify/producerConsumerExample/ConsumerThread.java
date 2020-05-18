package tr.salkan.code.java.threadExecutor.example.threads.waitnotify.producerConsumerExample;

import java.util.List;

public class ConsumerThread implements Runnable {

    private final List<Integer> list;

    public ConsumerThread(List<Integer> sharedList)
    {
        this.list = sharedList;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                consume();
            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException
    {
        synchronized (list)
        {
            while (list.isEmpty())
            {
                System.out.println("List is empty " + Thread.currentThread().getName() + " is waiting , size: " + list.size());
                list.wait();
            }
            Thread.sleep(1000);
            int i = (Integer) list.remove(0);
            System.out.println("Consumed: " + i);
            list.notifyAll();
        }
    }
}
