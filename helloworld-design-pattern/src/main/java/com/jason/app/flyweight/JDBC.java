package com.jason.app.flyweight;

/**
 * Created by jasonchang on 2017/5/3.
 * 資料庫連線，可享元的物件
 */
public class JDBC implements Flyweight {
    /**
     * 連線序號
     */
    private int number;

    public JDBC(int number) {
        this.number = number;
    }

    @Override
    public String getConn() {
        return "連線"+number;
    }
}
