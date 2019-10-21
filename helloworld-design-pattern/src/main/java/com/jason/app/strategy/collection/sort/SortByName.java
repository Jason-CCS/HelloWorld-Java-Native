package com.jason.app.strategy.collection.sort;

import java.util.Comparator;

/**
 * Created by jasonchang on 2017/4/21.
 */
public class SortByName implements Comparator<Village>{
    @Override
    public int compare(Village o1, Village o2) {
        if(o1.name.charAt(0) > o2.name.charAt(0)){
            return 1;
        }
        if(o1.name.charAt(0) < o2.name.charAt(0)){
            return -1;
        }
        return 0;
    }
}
