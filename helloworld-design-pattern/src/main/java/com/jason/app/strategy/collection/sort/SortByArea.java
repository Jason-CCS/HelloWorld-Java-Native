package com.jason.app.strategy.collection.sort;

import java.util.Comparator;

/**
 * Created by jasonchang on 2017/4/21.
 */
public class SortByArea implements Comparator<Village> {
    @Override
    public int compare(Village o1, Village o2) {
        if(o1.area > o2.area){
            return 1;
        }
        if(o1.area < o2.area){
            return -1;
        }
        return 0;
    }
}
