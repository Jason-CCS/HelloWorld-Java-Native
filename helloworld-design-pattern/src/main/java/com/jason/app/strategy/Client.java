package com.jason.app.strategy;

import com.jason.app.factory.simple.Adventurer;
import com.jason.app.factory.simple.TrainingCamp;

/**
 * Created by jasonchang on 2017/4/20.
 * 模式名：策略模式
 * 模式解說：選擇策略，產生相對應的效果
 * 範例解說：先建立一個策略介面，依照需求設定探險者的策略，並使出相對應的攻擊
 */
public class Client {

    public static void main(String[] args) {
        Adventurer adventurer = TrainingCamp.trainAdventurer("archer");
        adventurer.show();
        System.out.println();

        System.out.println("出現史萊姆");
        adventurer.attack();
        System.out.println();

        System.out.println("出現超大史萊姆");
        adventurer.setStrategy(new SkillStrategy());
        adventurer.attack();
        System.out.println();

        System.out.println("出現未知名的怪物");
        adventurer.setStrategy(new ItemStrategy());
        adventurer.attack();
        System.out.println();
    }
}
