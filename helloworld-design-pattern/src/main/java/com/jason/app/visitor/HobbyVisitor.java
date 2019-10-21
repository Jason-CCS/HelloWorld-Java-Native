package com.jason.app.visitor;

/**
 * Created by jasonchang on 2017/5/13.
 */
public class HobbyVisitor implements Visitor {
    @Override
    public void visit(Man man) {
        System.out.println(man.getName()+man.getHobby());
    }

    @Override
    public void visit(Woman woman) {
        System.out.println(woman.getName()+woman.getHobby());
    }

    @Override
    public void visit(Dog woman) {
        System.out.println(woman.getName()+woman.getHobby());
    }
}
