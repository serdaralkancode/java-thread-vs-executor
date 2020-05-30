package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.allof;

public class EntitiyExample {

    private String link;
    private String content;

    public EntitiyExample(String link, String content) {
        this.link = link;
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
