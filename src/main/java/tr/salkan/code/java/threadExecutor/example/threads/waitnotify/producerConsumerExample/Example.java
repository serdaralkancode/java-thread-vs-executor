package tr.salkan.code.java.threadExecutor.example.threads.waitnotify.producerConsumerExample;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {

        List<Integer> taskList = new ArrayList<Integer>();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new ProducerThread(taskList, MAX_CAPACITY), "Producer");
        Thread tConsumer = new Thread(new ConsumerThread(taskList), "Consumer");
        tProducer.start();
        tConsumer.start();
    }
}
