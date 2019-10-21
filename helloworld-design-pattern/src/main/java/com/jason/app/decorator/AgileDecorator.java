package com.jason.app.decorator;

/**
 * Created by jasonchang on 2017/2/8.
 */
public class AgileDecorator extends Decorator {
    public AgileDecorator(Adventurer adventurer) {
        super(adventurer);
    }

    @Override
    public void attack() {
        System.out.print("快速 ");
        super.attack();
    }
}
