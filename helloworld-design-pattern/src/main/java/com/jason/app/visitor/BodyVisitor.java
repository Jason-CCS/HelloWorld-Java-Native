package com.jason.app.visitor;

/**
 * Created by jasonchang on 2017/5/13.
 */
public class BodyVisitor implements Visitor {
    @Override
    public void visit(Man man) {
        System.out.printf("男人：名字是%s，身高是%d，體重是%d", man.getName(), man.getHeight(), man.getWeight());
        System.out.println();
    }

    @Override
    public void visit(Woman woman) {
        System.out.printf("女人：名字是%s，身高是%d，體重是%d", woman.getName(), woman.getHeight(), woman.getWeight());
        System.out.println();
    }

    @Override
    public void visit(Dog dog) {
        System.out.printf("狗：名字是%s，身高是%d，體重是%d", dog.getName(), dog.getHeight(), dog.getWeight());
        System.out.println();
    }
}
