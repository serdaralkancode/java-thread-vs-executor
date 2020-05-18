package tr.salkan.code.java.threadExecutor.example.threads.waitnotify.producerConsumerExample;

import java.util.List;

public class ProducerThread implements Runnable{

    private final List<Integer> list;
    private final int           MAX_CAPACITY;

    public ProducerThread(List<Integer> sharelist, int size)
    {
        this.list = sharelist;
        this.MAX_CAPACITY = size;
    }

    @Override
    public void run()
    {
        int counter = 0;
        while (true)
        {
            try
            {
                produce(counter++);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException
    {
        synchronized (list)
        {
            while (list.size() == MAX_CAPACITY)
            {
                System.out.println("List is full " + Thread.currentThread().getName() + " is waiting , size: " + list.size());
                list.wait();
            }

            Thread.sleep(1000);
            list.add(i);
            System.out.println("Produced: " + i);
            list.notifyAll();
        }
    }
}
