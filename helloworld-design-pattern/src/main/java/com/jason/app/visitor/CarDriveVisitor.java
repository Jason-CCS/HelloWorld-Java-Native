package com.jason.app.visitor;

/**
 * Created by jasonchang on 2017/5/12.
 * 用開車的觀點來比較
 */
public class CarDriveVisitor implements Visitor {

    @Override
    public void visit(Man man) {
        System.out.println("男人比較會開車");
    }

    @Override
    public void visit(Woman woman) {
        System.out.println("女人比較不會開車");
    }

    @Override
    public void visit(Dog dog) {
        System.out.println("狗根本不會開車");
    }
}
