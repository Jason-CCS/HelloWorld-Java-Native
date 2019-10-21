package com.jason.app.observer;

/**
 * Created by jasonchang on 2017/5/12.
 */
public class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.printf("%s收到新聞快報：%s \n", this.name, message);
    }
}
