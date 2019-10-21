package com.jason.app.flyweight;

/**
 * 模式名：享元模式（就是一個物件池的模式馬，而且這個範例還是非常非常的粗糙，因為只能給單一執行緒使用）
 * 模式解說：所謂的物件池/對象池，就是透過工廠取得某個物件後，進行客戶端的使用，使用完就回收，使得使用者不會產生過多的物件，
 * 而浪費環境資源。
 * 範例解說：此範例是以JDBC資料庫連線為例，在工廠初始化時，就給予5個連接物件而已，取得只能取這五個的其中一個。
 */
public class Client {
    public static void main(String[] args) {
        // 建立連線池（享元工廠）
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        // 建立100個連線，確認是不是都是取用連線池內的連線
        for (int i = 0; i < 100; i++) {
            // 取得JDBC
            Flyweight flyweight = flyweightFactory.produceFlyweight();
            // 建立連線
            String conn = flyweight.getConn();
            // 這邊為簡單範例所以就印出來看是不是同一個連線就好
            System.out.println(conn);
        }
    }
}
