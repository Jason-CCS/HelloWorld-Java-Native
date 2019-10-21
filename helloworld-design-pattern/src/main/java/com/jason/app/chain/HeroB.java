package com.jason.app.chain;

/**
 * Created by jasonchang on 2017/5/12.
 */
public class HeroB implements Handler {
    private Handler handler;

    @Override
    public String request(int i) {
        if (i == 2) {
            return "等級" + i + "就要靠B級英雄處理了";
        }

        return handler.request(i);
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}
