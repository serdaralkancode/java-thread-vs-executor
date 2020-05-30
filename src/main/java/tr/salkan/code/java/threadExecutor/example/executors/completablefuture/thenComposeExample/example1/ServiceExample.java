package tr.salkan.code.java.threadExecutor.example.executors.completablefuture.thenComposeExample.example1;

import java.util.ArrayList;
import java.util.List;

public class ServiceExample {

    private List<EntityExample> list = new ArrayList<>();

    public ServiceExample() {

        list.clear();
        list = createExampleList();


    }

    public EntityExample getById(Long id)
    {
        return list.stream().filter(entityExample -> entityExample.getId().equals(id)).findFirst().get();
    }

    public Double getEntitySalary(EntityExample e)
    {
        return e.getSalary();
    }


    private List<EntityExample> createExampleList() {

        EntityExample example1 = new EntityExample(1l,"AAAA",1000.95);
        EntityExample example2 = new EntityExample(2l,"BBBB",6000.12);
        EntityExample example3 = new EntityExample(3l,"CCCC",3000.78);
        EntityExample example4 = new EntityExample(4l,"DDDD",4780.56);

        list.add(example1);
        list.add(example2);
        list.add(example3);
        list.add(example4);

        return list;

    }
}
