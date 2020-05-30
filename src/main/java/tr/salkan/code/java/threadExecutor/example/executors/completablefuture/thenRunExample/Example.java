package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenRunExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Example {

    public static void main(String[] args) {

        ExampleObject exampleObject = new ExampleObject("url example");

        CompletionStage<Void> cf =
                CompletableFuture.runAsync(() -> exampleObject.dbProcess());

        cf = cf.thenRun(() -> exampleObject.closeConnection());

        ((CompletableFuture) cf).join();

    }

}
