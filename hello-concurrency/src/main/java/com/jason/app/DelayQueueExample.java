package com.jason.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by jc6t on 2015/11/27.
 * As class name
 */
public class DelayQueueExample {
    public static void main(String[] args) {
        Random rand = new Random(17);
        int maxTimeInMilliseconds=5000;
        ExecutorService es = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> q= new DelayQueue<DelayedTask>();
        // fill with tasks that have random delays
        for (int i = 0; i < 20; i++) {
            q.put(new DelayedTask(rand.nextInt(maxTimeInMilliseconds)));
        }
        // Set the stopping point
        q.add(new DelayedTask.EndSentinel(maxTimeInMilliseconds, es));
        es.execute(new DelayedTaskConsumer(q));
    }
}

class DelayedTaskConsumer implements Runnable{
    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    public void run(){
        while(!Thread.interrupted()){
            try {
                q.take().run(); // run task with the current thread
            } catch (InterruptedException e) {
                e.printStackTrace();
                // acceptable way to exit
            }
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}

class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();

    public DelayedTask(int delayInMilliseconds) {
        this.delta = delayInMilliseconds;
        this.trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
        sequence.add(this);
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public int compareTo(Delayed o) {
        DelayedTask that = (DelayedTask) o;
        if (this.trigger > that.trigger) return 1;
        if (this.trigger < that.trigger) return -1;
        return 0;
    }

    public void run() {
        System.out.print(this + " ");
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]", delta) + " Task: " + id;
    }

    public String summary() {
        return "(" + id + ":" + delta + ")";
    }

    public static class EndSentinel extends DelayedTask {
        private ExecutorService es;
        public EndSentinel(int endTimeInMilliseconds, ExecutorService es) {
            super(endTimeInMilliseconds);
            this.es = es;
        }

        @Override
        public void run() {
            for (DelayedTask dt : sequence) {
                System.out.print(dt.summary() + " ");
            }
            System.out.println();
            System.out.println(this+ " Calling shutdownNow()");
            es.shutdownNow();
        }
    }
}
