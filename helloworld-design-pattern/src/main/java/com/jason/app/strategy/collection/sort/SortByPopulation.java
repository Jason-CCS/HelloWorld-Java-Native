package com.jason.app.strategy.collection.sort;

import java.util.Comparator;

/**
 * Created by jasonchang on 2017/4/21.
 */
public class SortByPopulation implements Comparator<Village> {
    @Override
    public int compare(Village o1, Village o2) {
        if(o1.population > o2.population){
            return 1;
        }
        if(o1.population < o2.population){
            return -1;
        }
        return 0;
    }
}
