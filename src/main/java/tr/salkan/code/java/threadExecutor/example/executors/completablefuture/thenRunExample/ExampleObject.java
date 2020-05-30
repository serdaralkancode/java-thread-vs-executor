package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenRunExample;

public class ExampleObject {

    public String connectionUrl;

    public ExampleObject(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public void dbProcess()
    {
        System.out.println("db bussiness logic ");

        System.out.println("url is : " + connectionUrl);

        System.out.println("dbProcess finish");

    }


    public void closeConnection()
    {
        System.out.println("url : " + getConnectionUrl());
        System.out.println("Close connection");

    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }
}
