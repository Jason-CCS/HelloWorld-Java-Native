package com.jason.app.strategy;

/**
 * Created by jasonchang on 2017/4/20.
 */
public class SkillStrategy implements AttackStrategy {

    @Override
    public void execute(int originalAtk) {
        System.out.println("使用特殊技");
        System.out.println("攻擊點數：" + (originalAtk +10));
    }
}
