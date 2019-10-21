package com.jason.app.state;

/**
 * Created by jasonchang on 2017/5/12.
 * 定義每個狀態應有的行為
 */
public abstract class State {
    /**
     * 切換到下一個狀態
     */
    public abstract void change(Context context);

    /**
     * 取得狀態訊息
     */
    public abstract String getStateMessage();
}
