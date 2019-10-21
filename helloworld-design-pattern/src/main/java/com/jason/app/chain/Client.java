package com.jason.app.chain;

/**
 * Created by jasonchang on 2017/5/12.
 * 模式名：責任鍊模式
 * 模式解說：如果有一個要求需要一層一層的處理，每一個處理之間有先後順序，那麼可以使用這個模式
 * 範例解說：此範例是設定一個怪物等級，如果request(等級)是1，那由C等級英雄處理就好，如果是2則由B級英雄，如果大於3則是由A級英雄，
 * C級英雄處理不了，會交給下一級來處理
 */
public class Client {
    public static void main(String[] args) {
        HeroA a = new HeroA();
        HeroB b = new HeroB();
        HeroC c = new HeroC();

        c.setNextHandler(b);
        b.setNextHandler(a);

        for (int i = 0; i < 5; i++) {
            System.out.println(c.request(i));
        }
    }
}
