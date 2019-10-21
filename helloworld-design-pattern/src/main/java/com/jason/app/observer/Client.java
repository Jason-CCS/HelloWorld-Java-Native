package com.jason.app.observer;

/**
 * Created by jasonchang on 2017/5/12.
 * 模式名：觀察者模式
 * 模式解說：又可叫為發布者訂閱者模式，或是監聽與被監聽模式，是一對多的物件關係模式，當有一個物件發生了任何動作，
 * 其他監聽者應該有相對應的行為。如新聞發布者發布新聞時，所有的訂閱者都應該收到訊息。
 * 範例解說：此範例為新聞發布，所有的訂閱者收到後，會說明收到訊息。
 */
public class Client {
    public static void main(String[] args) {
        // 建立發布者
        Publisher publisher = new Publisher();

        // 建立兩個訂閱者
        Subscriber roy = new Subscriber("Roy");
        Subscriber su = new Subscriber("Su");
        Subscriber jason = new Subscriber("jason");

        // 訂閱
        publisher.addObserver(roy);
        publisher.addObserver(su);
        publisher.addObserver(jason);

        // 發布訊息
        publisher.inform("颱風警報");
    }
}
