package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenComposeExample.example1;

public class ServiceExample2 {

    private Integer value;

    public ServiceExample2(Integer value) {
        this.value = value;
    }

    public Double increaseSalary(EntityExample e)
    {
        return ((e.getSalary()*this.value)/100) + e.getSalary();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
