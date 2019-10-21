package com.jason.app.visitor;

/**
 * Created by jasonchang on 2017/5/12.
 */
public class Woman implements Element {
    private String name;
    private int height;
    private int weight;
    private String hobby = "喜歡看肥皂劇";

    public Woman(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public void accept(Visitor visitor) {
        // 執行該訪問者的方法，並傳入自身供訪問者使用
        visitor.visit(this);
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }
}
