package com.jason.app.decorator;

/**
 * Created by jasonchang on 2017/2/8.
 */
public class FireDecorator extends Decorator {
    public FireDecorator(Adventurer adventurer) {
        super(adventurer);
    }

    @Override
    public void attack() {
        System.out.print("燃燒 ");
        super.attack();
    }
}
