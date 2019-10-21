package com.jason.app.phaser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/**
 * Created by jc6t on 2015/12/9.
 * This one is much more difficult to understand, plz refer to PhaserExample2.
 */
public class PhaserExample {
    public static void main(String[] args) throws InterruptedException {
        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    int a = 0, b = 1;
                    for (int j = 0; j < 2000; j++) {
                        a = a + b;
                        b = a - b;
                    }
                    System.out.println("thread name: "+Thread.currentThread().getName()+", (a, b)=("+a+", "+b+")");
                }
            };
            tasks.add(runnable);
        }

        new PhaserExample().runTasks(tasks);
    }


    void runTasks(List<Runnable> tasks) throws InterruptedException {
        final Phaser phaser = new Phaser(1) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                return phase >= 1 || registeredParties == 0;
            }
        };

        for (final Runnable task: tasks){
            phaser.register();
            new Thread(){
                @Override
                public void run() {
                    do{
                        phaser.arriveAndAwaitAdvance();
                        task.run();
                    } while(!phaser.isTerminated());
                }
            }.start();
            Thread.sleep(500);
        }

        phaser.arriveAndDeregister();
    }
}
