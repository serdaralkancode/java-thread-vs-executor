package tr.salkan.code.java.threadExecutor.example.threads.joinVSwait;

public class ExampleJoin extends Thread {

    public static void main(String args[])
    {

        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();


        t1.start();
        try {
            t1.join();
        }
        catch (Exception e) {
            System.out.println(e);
        }


        t2.start();
    }

}

class Thread1 extends Thread {

    @Override
    public void run()
    {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                System.out.println(e);
            }
            System.out.print(i + " ");
        }
    }
}

class Thread2 extends Thread {

    @Override
    public void run()
    {
        for (char i = 'a'; i <= 'd'; i++) {
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                System.out.println(e);
            }
            System.out.print(i + " ");
        }
    }
}
