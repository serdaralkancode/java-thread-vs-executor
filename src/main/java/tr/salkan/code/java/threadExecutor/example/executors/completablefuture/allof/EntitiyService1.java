package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.allof;

public class EntitiyService1 {

    public EntitiyService1() {
    }

    public String getContentByLink(String link, EntitiyCreateService entitiyCreateService)
    {
        System.out.println("getContentByLink :" + link);
        String content =  entitiyCreateService.getAllList().stream().filter(entitiyExample -> entitiyExample.getLink().equals(link)).findFirst().get().getContent();

        System.out.println("content");

        return content;
    }
}