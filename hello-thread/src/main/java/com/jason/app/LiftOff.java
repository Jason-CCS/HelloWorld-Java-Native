package com.jason.app;

/**
 * Created by jc6t on 2015/3/2.
 */
public class LiftOff implements Runnable {
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;

    public LiftOff(){}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"LiftOff!")+"), ";
    }
    public void run(){
        while(countDown-->0){
            System.out.print(status());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
    }
}
