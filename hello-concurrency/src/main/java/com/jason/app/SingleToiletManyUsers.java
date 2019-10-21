package com.jason.app;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by jc6t on 2015/5/12.
 * Simulation many user but only one toilet.
 * When toilet is in use, other users should wait.
 */
public class SingleToiletManyUsers {
    private static class Toilet {
        private boolean isToiletUsing=false;
        private boolean using=false;
        private String user;

        public synchronized boolean useToilet() throws InterruptedException {
            System.out.println("for user "+user+", using is "+using);
            if(using!=true){
                using=true;
                System.out.println("for user "+user+", isToiletUsing is "+isToiletUsing);
                if(isToiletUsing!=true){
                    isToiletUsing=true;
                    // using toilet
                    System.out.printf("%s is starting to use toilet...", user);
                    System.out.println();
                    int seconds=new Random().nextInt(5)+1;
                    for(int i=0;i<seconds;i++){
                        System.out.println(user+" is using...");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    System.out.printf("%s finished using", user);
                    System.out.println();
                    isToiletUsing=false;
                }
                System.out.printf("%s exited toilet.\n", user);
                using=false;
                return true;
            }else{
                System.out.printf("%s is waiting", user);
                System.out.println();
                return false;
            }
        }

        public synchronized void setUser(String user) {
            this.user = user;
        }
    }

    private static class Person implements Callable<Boolean>{
        private String name;
        private Object obj;

        public Person(String name){
            this.name=name;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public Boolean call() throws Exception {
            System.out.println(name+" try to use "+obj.getClass().getSimpleName());
            Toilet toilet=obj instanceof Toilet ? ((Toilet) obj) : null;
            if(toilet!=null){
                toilet.setUser(name);
                return toilet.useToilet();
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String[] ppl={"p1","p2","p3"};
        ExecutorService es= Executors.newCachedThreadPool();
        Toilet toilet=new Toilet();
        ArrayList<Future> futureList=new ArrayList<Future>();
        for(String p:ppl){
            Person person=new Person(p);
            person.setObj(toilet);
            futureList.add(es.submit(person));
        }
        boolean notAllChecked=true;
        int personIdx=0;
        while (personIdx<ppl.length){
            Future f=futureList.get(personIdx);
            if(f.isDone()){
                Boolean result=(Boolean)f.get();
                System.out.println(ppl[personIdx]+" used toilet? "+result);
                personIdx++;
            }
        }
        es.shutdown();
    }
}
