package com.jason.app.mediator;

/**
 * Created by jasonchang on 2017/5/11.
 * 抽象同事
 */
public interface Colleague {
    /**
     * 發言
     */
    public void send(String message);

    /*
     * 密語
     */
    public void send(String message, Colleague colleague);

    /**
     * 接收訊息
     */
    public void receive(String message);

    /**
     * 接收密語訊息
     */
    public void receive(String message, Colleague colleague);
}
