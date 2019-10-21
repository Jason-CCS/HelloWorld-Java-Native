package com.jason.app.bridge;

/**
 * Created by jasonchang on 2017/5/3.
 * 作業系統標準
 */
public interface Implementor {

    /**
     * 開啟作業系統並載入各項常用軟體
     */
    void start();

    /**
     * 等待使用者的需求而執行相對應操作
     */
    void request();

    /**
     * 關閉所有軟體並關閉作業系統
     */
    void shutdown();
}
