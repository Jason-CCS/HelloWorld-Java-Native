package com.jason.app.factory._abstract;

public class Weapon {
    protected int range;

    public int getAtk() {
        return atk;
    }

    protected int atk;

    public void setRange(int range) {
        this.range = range;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void display() {
        System.out.println(this.getClass().getSimpleName() + "攻擊力 = " + atk + "，" + "攻擊範圍 = " + range);
    }
}