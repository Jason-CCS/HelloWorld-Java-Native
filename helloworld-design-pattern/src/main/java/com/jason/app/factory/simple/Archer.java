package com.jason.app.factory.simple;

import com.jason.app.factory._abstract.*;
import com.jason.app.strategy.AttackStrategy;

public class Archer implements Adventurer {
    private Cloth cloth;
    private Weapon weapon;
    private AttackStrategy strategy;

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getType() {
        System.out.println("我是弓箭手");
        return this.getClass().getSimpleName();
    }

    @Override
    public void show() {
        System.out.println("我是" + this.getClass().getSimpleName());
        cloth.display();
        weapon.display();
    }

    @Override
    public void attack() {
        if (strategy == null){
            System.out.println("攻擊點數：" + weapon.getAtk());
        }else {
            strategy.execute(weapon.getAtk());
        }
    }

    @Override
    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }
}