package com.jason.app.factory._abstract;

public class Cloth {
    public int getDefence() {
        return defence;
    }

    protected int defence;

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void display() {
        System.out.println(this.getClass().getSimpleName() + "防禦力 = " + defence);
    }
}