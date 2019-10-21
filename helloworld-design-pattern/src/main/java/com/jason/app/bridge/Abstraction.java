package com.jason.app.bridge;

/**
 * Created by jasonchang on 2017/5/3.
 * 電腦標準
 */
public interface Abstraction {
    /**
     * 開機
     */
    void powerOn();

    /**
     * 開機後做一些事，如寫word
     */
    void doSomthing();

    /**
     * 關機
     */
    void powerDown();
}
