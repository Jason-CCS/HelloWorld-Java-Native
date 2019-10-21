package com.jason.app.prototype;

import com.jason.app.decorator.Lancer;

/**
 * Created by jasonchang on 2017/2/22.
 */
public class Shadow extends Lancer implements Cloneable {

    public Shadow(String name) {
        super(name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("--- 複製 ---");
        return super.clone();
    }
}
