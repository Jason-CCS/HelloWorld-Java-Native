package com.jason.app.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonchang on 2017/5/12.
 * 新聞發布者
 */
public class Publisher implements Observable {
    /**
     * 訂閱者列表
     */
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void inform(final String message) {
        observers.forEach(observer -> observer.update(message));
    }
}
