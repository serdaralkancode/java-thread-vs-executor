package tr.salkan.code.java.threadExecutor.example.threads.createThread.RunnableInterface;

public class RunnableLambdaExample {

    public static void main(String[] args) {


        Runnable runnable = () -> {
            System.out.println("Runnable Lambda Thread name : " + Thread.currentThread().getName());
        };


        Thread thread = new Thread(runnable);

        thread.start();

    }

}
