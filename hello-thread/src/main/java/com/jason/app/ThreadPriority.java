package com.jason.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jc6t on 2015/3/2.
 * Try Thread Priority function.
 */
public class ThreadPriority implements Runnable {
    private int countDown = 5;
    private volatile double d; // no optimization
    private int priority;
    private String name;

    public ThreadPriority(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ThreadPriorityTest{" +
                Thread.currentThread() +
                "countDown=" + countDown +
                ", d=" + d +
                '}';
    }

    public void run() {
        Thread.currentThread().setName(name);
        Thread.currentThread().setPriority(priority);
        while (true) {
            // an expensive, interruptable operation:
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new ThreadPriority("High Priority thread", Thread.MAX_PRIORITY));
        for (int i = 0; i < 5; i++)
            es.execute(new ThreadPriority("low priority thread", Thread.MIN_PRIORITY));
        es.shutdown();
    }
}
