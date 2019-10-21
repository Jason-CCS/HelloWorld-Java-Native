package com.jason.app.chain;

/**
 * Created by jasonchang on 2017/5/12.
 * 英雄介面（警報請求處理介面）
 */
public interface Handler {
    /**
     * 請求栛助
     *
     * @param i
     *        警報等級
     */
    public String request(int i);

    /**
     * 下一個能處理的人
     */
    public void setNextHandler(Handler handler);
}
