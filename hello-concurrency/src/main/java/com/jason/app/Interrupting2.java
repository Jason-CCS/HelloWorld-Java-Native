package com.jason.app;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jc6t on 2015/7/2.
 * 展示lock.lockInterruptibly()，使得這個lock可以被interrupt 或 unlock
 */
public class Interrupting2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
}

class BlockedMutex{
    private Lock lock=new ReentrantLock();

    public BlockedMutex() {
        // 在建構子直接取得lock，展示一個有ReentrantLock可以被interrupt
        lock.lock();
        // 在這邊，因為lock已經被鎖住了，所以其他的task想要進來執行都是沒有辦法的
    }

    public void f(){
        try {
            lock.lockInterruptibly(); // get lock when meets the condition: lock is unlocked by other thread;
            // or throw Interrupted Exception when this thread is interrupted
            System.out.println("lock acquired in f()");
        } catch (Exception e) {
            System.out.println("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable{
    BlockedMutex blocked=new BlockedMutex();
    public void run(){
        System.out.println("Waiting for f() in BlockedMutex");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }
}