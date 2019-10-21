package com.jason.app;

/**
 * Created by jc6t on 2015/7/2.
 * main程式會啟動一個task執行TheSameTaskAcquireSameLockInMultiSyncMethods的f1，
 * 如果count--大於零，就會調用f2，一直下去。
 * 在這個狀況下，同一個task在synchronized f1()已經取得這個物件的lock了，也就是task，他可以繼續持有這個lock，
 * 來執行另外一個synchronized f2();
 */
public class TheSameTaskAcquireSameLockInMultiSyncMethods {

    public synchronized void f1(int count) {
        if (count-- > 0) {
            System.out.println("f1 calling f2 for count=" + count);
            this.f2(count);
        }
    }

    public synchronized void f2(int count) {
        if (count-- > 0) {
            System.out.println("f2 calling f1 for count=" + count);
            this.f1(count);
        }
    }

    public static void main(String[] args) {
        final TheSameTaskAcquireSameLockInMultiSyncMethods task = new TheSameTaskAcquireSameLockInMultiSyncMethods();
        new Thread() {
            @Override
            public void run() {
                task.f1(10);
            }
        }.start();
    }
}
