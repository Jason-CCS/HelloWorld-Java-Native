package com.jason.app.observer;

/**
 * Created by jasonchang on 2017/5/12.
 * 觀察者（訂閱者）
 */
public interface Observer {
    /**
     * 被觀察者狀態變更通知（發布者發布訊息）
     */
    public void update(String message);
}
