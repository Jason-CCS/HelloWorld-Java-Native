package com.jason.app.decorator;

/**
 * Created by jasonchang on 2017/2/8.
 */
public class StrongDecorator extends Decorator {
    public StrongDecorator(Adventurer adventurer) {
        super(adventurer);
    }

    @Override
    public void attack() {
        System.out.print("強力 ");
        super.attack();
    }
}
