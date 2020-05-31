# java-thread-vs-executor
**JDK VERSION :** JDK 11 - [AMAZON CORRETTO](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)

---

Examples
------

* Thread
  
  > Thread class and Runnable Interface 
  
  > Thread sleep & join & priority
  
  > Thread Synchronization
  
  > Thread Deadlock
  
  > Atomic
  
  > Thread wait & notify
  
  > CountDownLatch
  
  > CyclicBarrier
  
  [example code](https://github.com/serdaralkancode/java-thread-vs-executor/tree/master/src/main/java/tr/salkan/code/java/threadExecutor/example/threads)
  
* Executor Thread Pooling

   > Thread Pooling
   
   > Single Thread Pool
   
   > Fixed Thread Pool
   
   > Cached Thread Pool
   
   > Custom Thread Pool 
   
   > BlockingQueue & RejectedExecutionHandler & ThreadFactory & Core and Max Pool size & KeepAlive
   
   [example code](https://github.com/serdaralkancode/java-thread-vs-executor/tree/master/src/main/java/tr/salkan/code/java/threadExecutor/example/executors/create)
   
* Callable & Future

   > Callable & Runnable Object 
   
   > Future Object 
   
   [example code](https://github.com/serdaralkancode/java-thread-vs-executor/tree/master/src/main/java/tr/salkan/code/java/threadExecutor/example/executors/callableAndFuture)
   
* CompletableFuture

  > runAsync & supplyAsync method
  
  > thenApply & thenAccept & thenRun & thenCompose 
  
  > join & get
  
  > allOf & anyOf
  
  > CompletableFuture with Executor
  
  > Exception with exceptionally method
  
  > Exception with handle method
  
  [example code](https://github.com/serdaralkancode/java-thread-vs-executor/tree/master/src/main/java/tr/salkan/code/java/threadExecutor/example/executors/completablefuture)
  
* Fork/Join Framework

  > RecursiveAction 
  
  > RecursiveTask
  
  [example code](https://github.com/serdaralkancode/java-thread-vs-executor/tree/master/src/main/java/tr/salkan/code/java/threadExecutor/example/forkJoin)
  
  Resources : [Rules of ThreadPoolExecutor pool size](http://www.bigsoft.co.uk/blog/2009/11/27/rules-of-a-threadpoolexecutor-pool-size)
  
  
Here are Sun's rules for thread creation in simple terms:

 > If the number of threads is less than the corePoolSize, create a new Thread to run a new task.
 
 > If the number of threads is equal (or greater than) the corePoolSize, put the task into the queue.
 
 > If the queue is full, and the number of threads is less than the maxPoolSize, create a new thread to run tasks in.
 
 > If the queue is full, and the number of threads is greater than or equal to maxPoolSize, reject the task.

The long and the short of it is that new threads are only created when the queue fills up, so if you're using an unbounded queue then the number of threads will not exceed corePoolSize.

