package com.jason.app.strategy;

import java.util.Random;

/**
 * Created by jasonchang on 2017/4/20.
 */
public class ItemStrategy implements AttackStrategy {
    @Override
    public void execute(int originalAtk) {
        System.out.println("使用道具");
        System.out.println("攻擊點數：" + new Random().nextInt(100));
    }
}
