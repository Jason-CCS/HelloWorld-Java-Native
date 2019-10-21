package com.jason.app.decorator;

/**
 * Created by jasonchang on 2017/2/8.
 */
public class Lancer implements Adventurer{

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Lancer(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("長槍攻擊 by " + name);
    }
}
