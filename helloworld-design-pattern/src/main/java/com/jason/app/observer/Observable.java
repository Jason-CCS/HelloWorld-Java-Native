package com.jason.app.observer;

/**
 * Created by jasonchang on 2017/5/12.
 * 被觀察者（發布者）
 */
public interface Observable {
    /**
     * 增加觀察者
     */
    public void addObserver(Observer observer);

    /**
     * 移除觀察者
     */
    public void removeObserver(Observer observer);

    /**
     * 通知觀察者
     */
    public void inform(String message);
}
