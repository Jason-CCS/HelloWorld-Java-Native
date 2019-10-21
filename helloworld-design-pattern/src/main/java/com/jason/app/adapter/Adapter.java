package com.jason.app.adapter;

import com.jason.app.decorator.Adventurer;

/**
 * Created by jasonchang on 2017/2/9.
 * 模式名：轉接器模式
 * 模式解說：將某物件的功能直接轉換成另外一個功能，如110V插頭 轉換成 220V插頭
 * 範例解說：讓Adapter接受Adventurer的物件，讓Adventurer可以做其他角色能做的function
 * 轉換Adaptee的function，從A角色會的function，轉換成B角色會的function
 */
public class Adapter implements Wizard {

    private Adventurer adventurer;

    public Adapter() {
    }

    public Adapter(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    @Override
    public void fireBall() {
        System.out.println("唸出咒語");
        adventurer.attack();
        System.out.println("火球發射出去了");
    }
}
