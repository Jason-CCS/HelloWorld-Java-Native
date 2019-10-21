package com.jason.app.state;

/**
 * Created by jasonchang on 2017/5/12.
 * 收到訂單
 */
public class ReceiveState extends State {

    /**
     * 下一個狀態為訂單準備中
     * @param context
     */
    @Override
    public void change(Context context) {
        context.setState(new ReadyState());
    }

    @Override
    public String getStateMessage() {
        return "已收到您的訂單囉";
    }
}
