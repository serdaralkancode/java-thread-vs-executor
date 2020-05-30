package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.allof;

public class EntitiyService2 {

    public EntitiyService2() {
    }

    public String getCountWords(String link, EntitiyCreateService entitiyCreateService)
    {
        int count = 0;

        String str = entitiyCreateService.getAllList().stream().filter(entitiyExample -> entitiyExample.getLink().equals(link)).findFirst().get().getContent();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ')
                count++;
        }

        System.out.println("count : " + count);

        return String.valueOf(count);

    }
}
