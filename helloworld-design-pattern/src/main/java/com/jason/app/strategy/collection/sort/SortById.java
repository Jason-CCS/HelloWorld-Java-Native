package com.jason.app.strategy.collection.sort;

import java.util.Comparator;

/**
 * Created by jasonchang on 2017/4/21.
 */
public class SortById implements Comparator<Village>{
    @Override
    public int compare(Village o1, Village o2) {
        if(o1.id > o2.id){
            return 1;
        }
        if(o1.id < o2.id){
            return -1;
        }
        return 0;
    }
}
