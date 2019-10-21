package com.jason.app.visitor;

/**
 * Created by jasonchang on 2017/5/13.
 */
public class Dog implements Element {
    private String name;
    private int height;
    private int weight;
    private String hobby = "喜歡啃骨頭";

    public Dog(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public void accept(Visitor visitor) {
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
