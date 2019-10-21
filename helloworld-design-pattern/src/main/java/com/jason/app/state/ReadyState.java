package com.jason.app.state;

/**
 * Created by jasonchang on 2017/5/12.
 * 訂單狀態：商品準備中
 */
public class ReadyState extends State {

    /**
     * 下一個狀態為商品已出貨
     */
    @Override
    public void change(Context context) {
        context.setState(new ShipmentState());
    }

    @Override
    public String getStateMessage() {
        return "商品準備中，可至網站查詢進度。";
    }
}
