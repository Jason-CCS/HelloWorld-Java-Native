package com.jason.app.strategy.collection.sort;

/**
 * Created by jasonchang on 2017/4/21.
 */
public class Village {
    int id;
    String name;
    double area;
    int population;

    public Village(int id, String name, int population, double area) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.population = population;
    }

    @Override
    public String toString() {
        return id + "." + name + "(人口: " + population + " 面積: "+ area + ")";
    }
}
