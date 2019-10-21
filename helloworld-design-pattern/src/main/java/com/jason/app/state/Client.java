package com.jason.app.state;

/**
 * Created by jasonchang on 2017/5/12.
 * 模式名：狀態模式
 * 模式解說：當某物件的某狀態改變時，其相對應的功能也改變可以使用此模式
 * 範例解說：使範例為網路購物時，從收到訂單->訂單準備中->已出貨，有三個狀態的不同，其在context.getOrderMessage()會得到不同的訊息。
 */
public class Client {
    public static void main(String[] args) {
        // 使用者只要透過Context，即可切換狀態和取得狀態訊息
        Context context = new Context();
        context.setState(new ReceiveState());

        String msg = context.getOrderMessage();
        System.out.println(msg);
        context.nextState();

        msg = context.getOrderMessage();
        System.out.println(msg);
        context.nextState();

        msg = context.getOrderMessage();
        System.out.println(msg);

        // 沒有下個狀態了拋出例外
        context.nextState();
    }
}
