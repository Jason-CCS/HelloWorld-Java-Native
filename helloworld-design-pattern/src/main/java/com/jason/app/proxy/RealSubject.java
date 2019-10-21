package com.jason.app.proxy;

/**
 * Created by jasonchang on 2017/5/3.
 */
public class RealSubject implements Subject {
    /**
     * 委託人姓名
     */
    private String name;

    /**
     * 建構式傳入委託人姓名
     * @param name
     */
    public RealSubject(String name) {
        this.name = name;
    }


    @Override
    public void speak(String words) {
        System.out.println(name + "說："+ words);
    }
}
