package com.jason.app.mediator;

/**
 * Created by jasonchang on 2017/5/11.
 * 抽象中介者
 */
public interface Mediator {

    /**
     * 加入討論
     */
    public void join(Colleague colleague);

    /**
     * 發言
     */
    public void send(String message);

    /*
     * 密語
     */
    public void send(String message, Colleague sender, Colleague receiveer);
}
