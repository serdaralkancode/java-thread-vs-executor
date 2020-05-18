package tr.salkan.code.java.threadExecutor.example.threads.join;

public class ThreadJoinExample {

    public static void main(String[] args) {


        // Thread 1
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Exit Thread 1");
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Exit Thread 2");
        });

        System.out.println("Thread 1 start");
        thread1.start();

        System.out.println("Waiting for Thread 1 to complete");
        try {
            thread1.join(3000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        System.out.println("Starting Thread 2 now");
        thread2.start();
    }
}
