package tr.salkan.code.java.threadExecutor.example.threads.createThread.ThreadClass;

public class ThreadExample2 {


    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();

        MyThread thread2 = new MyThread();
        thread2.start();

        System.out.println(Thread.currentThread()
                .getName());

    }

    private static class MyThread extends Thread {


        @Override
        public void run () {

            System.out.println("MyThread name : " + Thread.currentThread().getName());
        }
    }

}
