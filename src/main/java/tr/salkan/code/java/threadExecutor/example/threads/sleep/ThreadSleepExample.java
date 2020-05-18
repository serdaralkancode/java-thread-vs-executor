package tr.salkan.code.java.threadExecutor.example.threads.sleep;

public class ThreadSleepExample {

    public static void main(String[] args) {

        System.out.println("Thread name : " + Thread.currentThread().getName());

        String[] poet = {"Maviye,",
                "Maviye çalar gözlerin,",
                "Yangın mavisine.",
                "Rüzgarda asi,",
                "Körsem,",
                "Senden gayrısına yoksam,",
                "Bozuksam,",
                "Can benim, düş benim,",
                "Ellere nesi?",
                "Hadi gel,",
                "Ay Karanlık..."};

        Runnable runnable = () -> {
            System.out.println("Runnable Thread name  : " + Thread.currentThread().getName());

            for(String p: poet) {
                System.out.println(p);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

    }
}
