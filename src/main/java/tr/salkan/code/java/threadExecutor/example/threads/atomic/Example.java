package tr.salkan.code.java.threadExecutor.example.threads.atomic;

// synchronized vs atomic

import java.util.concurrent.atomic.AtomicInteger;

public class Example {

    public static class CounterSync {
        int count = 0;
        public synchronized void increment(){
            count++;
        }

        public synchronized void decrement(){
            count--;
        }
    }

    public static class CounterAtomic {
        AtomicInteger count = new AtomicInteger();

        public  void increment(){               // not use synchronized
            count.incrementAndGet();
        }

        public void decrement(){                // not use synchronized
            count.decrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final CounterSync counterSync = new CounterSync();
        final CounterAtomic counterAtomic = new CounterAtomic();

        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                int j = i & 1;
                if (j == 0) {
                    counterSync.increment();
                    counterAtomic.increment();
                } else {
                    counterSync.decrement();
                    counterAtomic.decrement();
                }
            }
        };

        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
        }

        for (Thread t : threads)
            t.start();

        for (Thread t : threads)
            t.join();

        System.out.println("Sync count = " + counterSync.count);
        System.out.println("Atomic count = " + counterAtomic.count.intValue());
    }

}
