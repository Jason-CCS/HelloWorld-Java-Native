package com.jason.app.bridge;

/**
 * Created by jasonchang on 2017/5/3.
 */
public class Windows implements Implementor{
    @Override
    public void start() {
        System.out.println("開啟Windows，將必要軟體載入至記憶體。。。");
    }

    @Override
    public void request() {
        System.out.println("使用者對作業系統做動作。。。");
    }

    @Override
    public void shutdown() {
        System.out.println("使用者點擊關閉電腦，關閉所有軟體中。。。");
    }
}
