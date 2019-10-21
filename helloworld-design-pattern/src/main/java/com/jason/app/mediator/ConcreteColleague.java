package com.jason.app.mediator;

/**
 * Created by jasonchang on 2017/5/11.
 * 真實的同事物件
 */
public class ConcreteColleague implements Colleague {
    private Mediator mediator;
    private String name;

    /**
     * 於建構式傳入仲介者與姓名
     */
    public ConcreteColleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void send(String message) {
        System.out.println(name + "對大家說：" + message);
        // 跟中介者說我要說啥就可以了，不用一個個去對每個人說
        mediator.send(message);
    }

    @Override
    public void send(String message, Colleague colleague) {
        System.out.println(name + "對" + colleague + "說：" + message);
        // 跟中介者說我要說什麼、我是誰，然後要跟誰說
        mediator.send(message, this, colleague);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + "接收到訊息" + message);
    }

    @Override
    public void receive(String message, Colleague colleague) {
        System.out.println(this.name + "接收到" + colleague + "的訊息：" + message);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
