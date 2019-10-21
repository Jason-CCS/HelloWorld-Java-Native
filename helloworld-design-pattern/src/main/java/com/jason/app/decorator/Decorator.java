package com.jason.app.decorator;

/**
 * Created by jasonchang on 2017/2/8.
 */
public class Decorator implements Adventurer{

    protected Adventurer adventurer;

    public Decorator(Adventurer adventurer) {

        this.adventurer = adventurer;
    }

    @Override
    public void attack() {
        adventurer.attack();
    }
}
