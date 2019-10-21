package com.jason.app.singleton;

/**
 * Created by jasonchang on 2017/4/20.
 * 模式名：單例模式
 * 模式解說：整個程式只能取得單一一個instance
 * 範例解說：使用synchronized，來控制多個thread時也只能取得同一個instance
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // 這裡面跑很了多code，建立物件需要花費很多資源
    }

    // 確保 thread-safe
    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return  instance;
    }
}
