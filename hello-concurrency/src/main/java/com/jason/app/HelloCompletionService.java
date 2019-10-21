package com.jason.app;

import java.util.concurrent.*;

/**
 * Created by jc6t on 2015/8/31.
 * as class name
 */
public class HelloCompletionService {


    public static void main(String[] args) {
        ExecutorService es=Executors.newCachedThreadPool();
        CompletionService<Task> cs=new ExecutorCompletionService<Task>(es);
        cs.submit(new Task());
        try {
            System.out.println("=====non-blocking cs=====");
            System.out.println(cs.poll().get());

//            System.out.println("======blocking cs========");
//            System.out.println(cs.take().get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            es.shutdownNow();
        }


    }

    static class Task implements Callable<Task>{
        private String name="hello cs!";

        public Task call() throws Exception {
            TimeUnit.SECONDS.sleep(5);
            return this;
        }
    }
}
