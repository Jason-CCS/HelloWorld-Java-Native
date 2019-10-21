package com.jason.app.adapter;

import com.jason.app.decorator.Adventurer;

/**
 * Created by jasonchang on 2017/2/9.
 */
public class Archer implements Adventurer{

    private String name;

    public Archer(String name){
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("射箭 by " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
