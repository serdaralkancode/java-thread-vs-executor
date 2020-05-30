package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.allof;

import java.util.ArrayList;
import java.util.List;

public class EntitiyCreateService {

    private List<EntitiyExample> entitiyExampleList = new ArrayList<>();

    private static String metin = "Lorem Ipsum";

    public EntitiyCreateService() {

        init();

    }

    private void init() {

            for(int i = 1; i <= 100; i++)
            {
                EntitiyExample entitiyExample = new EntitiyExample("link_" + i, createContent(i));

                entitiyExampleList.add(entitiyExample);
            }

    }

    private String createContent(int i) {

            String returnMetin = "link_" + i + "_content_";

            for(int x = 1; x<=i; x++)
            {
                returnMetin +=  x + "_" + metin;
            }

            return returnMetin;

    }

    public List<EntitiyExample> getAllList()
    {
        return entitiyExampleList;
    }

    public List<EntitiyExample> getEntitiyExampleList() {
        return entitiyExampleList;
    }

    public void setEntitiyExampleList(List<EntitiyExample> entitiyExampleList) {
        this.entitiyExampleList = entitiyExampleList;
    }

    public static String getMetin() {
        return metin;
    }

    public static void setMetin(String metin) {
        EntitiyCreateService.metin = metin;
    }
}
