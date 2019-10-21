package com.jason.app.chain;

/**
 * Created by jasonchang on 2017/5/12.
 */
public class HeroA implements Handler {
    private Handler handler;

    @Override
    public String request(int i) {
        if (i >= 3) {
            return "等級" + i + "只能給A級英雄處理啦";
        }

        return "沒有小於1的警報啦";
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}
