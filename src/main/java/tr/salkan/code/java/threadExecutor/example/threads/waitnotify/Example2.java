package tr.salkan.code.java.threadExecutor.example.threads.waitnotify;


// notifyAll example
public class Example2 {

    public static void main(String[] args) {

        ExampleObject message = new ExampleObject("Hello World");

        WaiterThread waiter = new WaiterThread(message);
        Thread waiterThread = new Thread(waiter, "waiterThread");
        waiterThread.start();

        Thread waiterThread2 = new Thread(waiter, "waiterThread2");
        waiterThread2.start();

        Thread waiterThread3 = new Thread(waiter, "waiterThread3");
        waiterThread3.start();

        NotifierThread notifier = new NotifierThread(message);
        Thread notifierThread = new Thread(notifier, "notifierThread");
        notifierThread.start();

    }
}

class ExampleObject {

    private String text;

    public ExampleObject(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

class WaiterThread implements Runnable {

    ExampleObject exampleObject;

    public WaiterThread(ExampleObject exampleObject) {
        this.exampleObject = exampleObject;
    }

    @Override
    public void run() {
        synchronized (exampleObject) {
            try {
                System.out.println("WaiterThread thread name" + Thread.currentThread().getName());
                exampleObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("WaiterThread finished name : " + Thread.currentThread().getName());
        System.out.println("WaiterThread  message:  " + exampleObject.getText());
    }

}

class NotifierThread implements Runnable {

    ExampleObject exampleObject;

    public NotifierThread(ExampleObject exampleObject) {
        this.exampleObject = exampleObject;
    }

    @Override
    public void run() {
        System.out.println("NotifierThread is sleeping for 4 seconds at ");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        synchronized (exampleObject) {
            exampleObject.setText("NotifierTherad set text");
            System.out.println("NotifierTherad is wake all thread ");
            exampleObject.notifyAll();
        }

    }

}
