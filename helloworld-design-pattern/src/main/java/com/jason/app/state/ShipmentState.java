package com.jason.app.state;

/**
 * Created by jasonchang on 2017/5/12.
 * 商品已出貨
 */
public class ShipmentState extends State {
    @Override
    public void change(Context context) {
        throw new RuntimeException("沒有下一個狀態了");
    }

    @Override
    public String getStateMessage() {
        return "商品已出貨，可至網站查詢進度";
    }
}
