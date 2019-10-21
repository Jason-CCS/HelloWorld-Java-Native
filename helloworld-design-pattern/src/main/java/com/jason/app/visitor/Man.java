package com.jason.app.visitor;

/**
 * Created by jasonchang on 2017/5/12.
 */
public class Man implements Element {
    private String name;
    private int height;
    private int weight;
    private String hobby = "喜歡運動";

    public Man(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public void accept(Visitor visitor) {
        // 執行該訪問者的方法，並傳入自身供訪問者使用
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getHobby() {
        return hobby;
    }
}
