package com.jason.app.chain;

/**
 * Created by jasonchang on 2017/5/12.
 */
public class HeroC implements Handler {
    private Handler handler;

    @Override
    public String request(int i) {
        if (i == 1) {
            return "等級" + i + "交給C級英雄處理就可以啦";
        }

        return handler.request(i);
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}
