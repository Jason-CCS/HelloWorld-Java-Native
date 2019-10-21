package com.jason.app.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by jasonchang on 2017/5/3.
 * 享元工廠
 */
public class FlyweightFactory {
    /**
     * 連線池
     */
    public Map<Integer, Flyweight> cacheMap = new HashMap<>();

    private Random random = new Random();

    public FlyweightFactory(){
        // 在連線池內加入五個連線
        for (int i = 0; i < 5; i++) {
            cacheMap.put(i, new JDBC(i));
        }
    }

    public Flyweight produceFlyweight() {
        // 隨機產生一個0~4的key
        int key = random.nextInt(5);
        return cacheMap.get(key);
    }
}
