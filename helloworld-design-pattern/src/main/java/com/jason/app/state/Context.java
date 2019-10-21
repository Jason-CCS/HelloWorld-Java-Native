package com.jason.app.state;

/**
 * Created by jasonchang on 2017/5/12.
 * 供使用者管理狀態與取得狀態訊息
 */
public class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public String getOrderMessage() {
        return state.getStateMessage();
    }

    /**
     * 將自已傳入，供狀態自行決定下一個狀態
     */
    public void nextState() {
        state.change(this);
    }
}
