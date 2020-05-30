package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.allof;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        EntitiyCreateService entitiyCreateService = new EntitiyCreateService();

        EntitiyService1 entitiyService1 = new EntitiyService1();
        EntitiyService2 entitiyService2 = new EntitiyService2();

        String link = "link_45";
        String link2 = "link_80";

        CompletableFuture<String> contentF = CompletableFuture.supplyAsync(() -> entitiyService1.getContentByLink(link,entitiyCreateService));

        CompletableFuture<String> countWordF = CompletableFuture.supplyAsync(() -> entitiyService2.getCountWords(link2,entitiyCreateService));

        CompletableFuture<Void> allInfoFuture = CompletableFuture.allOf(contentF, countWordF);

        Void allInfo = allInfoFuture.join();

        System.out.println(" content : " + contentF.get() + " count : " + countWordF.get());
    }
}
