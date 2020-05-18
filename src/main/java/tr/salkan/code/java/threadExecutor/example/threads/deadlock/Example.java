package tr.salkan.code.java.threadExecutor.example.threads.deadlock;


/*
        Thread 1 -> block methodA and wait for methodB ( Thread 2 block this method)

        Thread 2 -> block methodB and wait for methodA ( Thread 1 block this method=

 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 7, 9, 11));


        Thread thread1 = new Thread(() -> {
            orderList(list1, list2, 2);
        });
        Thread thread2 = new Thread(() -> {
            orderList(list2, list1, 9);
        });

        thread1.start();
        thread2.start();
    }

    private static void orderList (List<Integer> from, List<Integer> to, Integer item) {
        synchronized (from) {
            synchronized (to) {
                if(from.remove(item)){
                    to.add(item);
                }
            }
        }
    }
}
