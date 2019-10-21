package com.jason.app.bridge;

/**
 * Created by jasonchang on 2017/5/3.
 */
public class Mac implements Abstraction{
    private Implementor os;

    public Mac(Implementor os) {
        this.os = os;
    }

    @Override
    public void powerOn() {
        System.out.println("蘋果電腦：");
        os.start();
    }

    @Override
    public void doSomthing() {
        System.out.println("蘋果電腦：");
        os.request();
    }

    @Override
    public void powerDown() {
        System.out.println("蘋果電腦：");
        os.shutdown();
    }
}
